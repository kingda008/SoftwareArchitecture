# 手写apt

```java
@BindView(R.id.txt)
TextView txt;
```

通过这样在filed上面增加了一个bindview注解。就可以将txt和布局中id绑定。Android系统中是通过activity中findviewbyid实现的。所以view绑定框架其实就是实现了findviewbyid过程。设计大体可以有以下步骤：
1，编写注解处理器，解析属性上的注解。拿到所有含有注解的activity，和该activity上属性类型，属性名称，对应id。

2，生成binding工具类。在此类中有个register方法，在此方法中用第一步拿到的数据完成findviewbyid过程。这个环节是javaopet 工具完成

3，activity 调用工具类，完成绑定。这里有2个选择，第一是调用binding工具类，第二种通过第三方转一下，也就是Apt类。显示第二种方式更好。

这里有一个出色的设计就是 Unbinder接口。

特意将解绑方法放进接口中，这样可以activity执行绑定方法的时候直接返回该接口，可以用来触发解绑，并且限定了只能调用unbind方法，而不是调用bind工具类中其他方法。  并且如果执行出异常会返回一个空的unbinder，防止执行unbind时报错。

有诸多优点，设计不错



框架划分3个模块 Annotation提供注解，compile负责解析注解并生成文件，libapt负责提供对外方法。



## annation Java library

```java
/**
 * 注解 绑定view
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BindView {
    @IdRes int value();
}
```

## compile Javalibrary

```java
@AutoService(Processor.class)
public class KJ01Processor extends AbstractProcessor {
    /**
     * Filer 就是文件流输出路径，当我们用AbstractProcess生成一个java类的时候，我们需要保存在Filer指定的目录下。
     */
    private Filer mFiler;
    /**
     * Elements 获取元素信息的工具，比如说一些类信息继承关系等。
     */
    private Elements mElementUtils;


    private Set<Class<? extends Annotation>> getSupportedAnnotations() {
        Set<Class<? extends Annotation>> annotations = new LinkedHashSet<>();
        annotations.add(BindView.class);

        return annotations;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        for (Class<? extends Annotation> annotation : getSupportedAnnotations()) {
            //com.baoge.kj01_annotation.BindView  全路径名称
            System.out.println("getCanonicalName " + annotation.getCanonicalName());
            types.add(annotation.getCanonicalName());
        }
        return types;
    }


    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mFiler = processingEnvironment.getFiler();
        mElementUtils = processingEnvironment.getElementUtils();

    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        System.out.println("process##################");


        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(BindView.class);
        Map<Element, List<Element>> elementsMap = new LinkedHashMap<>();


        for (Element element : elements) {

            Element enclosingElement = element.getEnclosingElement();
            System.out.println("elment info:");

            /**
             * txt , MainActivity,FIELD,com.baoge.kj01_apttest.MainAcvitity
             */
            System.out.println(element.getSimpleName().toString() + "\r\n" + enclosingElement.getSimpleName().toString());
            System.out.println(element.getKind().toString() + "\r\n" + enclosingElement.asType().toString());

            for (Modifier modifiers : element.getModifiers()) {
                System.out.println("Modifier info:");
                System.out.println(modifiers.getClass().getSimpleName());
            }


            /**
             * 以外层类全名为key，element为value 保存进hashmap
             */
            List<Element> viewBindElements = elementsMap.get(enclosingElement);
            if (viewBindElements == null) {
                viewBindElements = new ArrayList<>();
                elementsMap.put(enclosingElement, viewBindElements);
            }

            viewBindElements.add(element);

        }


        // 生成代码
        for (Map.Entry<Element, List<Element>> entry : elementsMap.entrySet()) {
            Element enclosingElement = entry.getKey();
            List<Element> viewBindElements = entry.getValue();

            // public final class xxxActivity_ViewBinding implements Unbinder
            String activityClassNameStr = enclosingElement.getSimpleName().toString();
            ClassName activityClassName = ClassName.bestGuess(activityClassNameStr);
            ClassName unbinderClassName = ClassName.get("com.baoge.kj01_libapt", "Unbinder");
            TypeSpec.Builder classBuilder = TypeSpec.classBuilder(activityClassNameStr + "_ViewBinding")
                    .addModifiers(Modifier.FINAL, Modifier.PUBLIC).addSuperinterface(unbinderClassName)
                    .addField(activityClassName, "activity", Modifier.PRIVATE);


            // 实现 unbind 方法
            // android.support.annotation.CallSuper
//            ClassName callSuperClassName = ClassName.get("androidx.annotation", "CallSuper");
//            MethodSpec.Builder unbindMethodBuilder = MethodSpec.methodBuilder("unbind")
//                    .addAnnotation(Override.class)
//                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
//                    .addAnnotation(callSuperClassName);
            //已经引入了sdk，可以直接使用sdk中的注解
            MethodSpec.Builder unbindMethodBuilder = MethodSpec.methodBuilder("unbind")
                    .addAnnotation(Override.class)
                    .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                    .addAnnotation(CallSuper.class);

            unbindMethodBuilder.addStatement("$T activity = this.activity", activityClassName);
            unbindMethodBuilder.addStatement("if (activity == null) throw new IllegalStateException(\"Bindings already cleared.\");");

            // 构造函数
            MethodSpec.Builder constructorMethodBuilder = MethodSpec.constructorBuilder()
                    .addParameter(activityClassName, "activity");
            // this.target = target;
            constructorMethodBuilder.addStatement("this.activity = activity");
            // findViewById 属性
            for (Element viewBindElement : viewBindElements) {
                // target.textView1 = Utils.findRequiredViewAsType(source, R.id.tv1, "field 'textView1'", TextView.class);
                // target.textView1 = Utils.findViewById(source, R.id.tv1);
                String filedName = viewBindElement.getSimpleName().toString();
                ClassName utilsClassName = ClassName.get("com.baoge.kj01_libapt", "Utils");
                int resId = viewBindElement.getAnnotation(BindView.class).value();
                constructorMethodBuilder.addStatement("activity.$L = $T.findViewById(activity, $L)", filedName, utilsClassName, resId);
                // target.textView1 = null;
                unbindMethodBuilder.addStatement("activity.$L = null", filedName);
            }


            classBuilder.addMethod(unbindMethodBuilder.build());
            classBuilder.addMethod(constructorMethodBuilder.build());

            // 生成类，看下效果
            try {
                String packageName = mElementUtils.getPackageOf(enclosingElement).getQualifiedName().toString();

                JavaFile.builder(packageName, classBuilder.build())
                        .addFileComment(" 自动生成")
                        .build().writeTo(mFiler);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("翻车了！");
            }
        }
        return false;
    }
}
```

## libapt Android library

```java
public interface Unbinder {
    @UiThread
    void unbind();

    Unbinder EMPTY = new Unbinder() {
        @Override
        public void unbind() {
        }
    };
}
```

```java
public class Utils {
    public static final <T extends View> T findViewById(Activity activity, int viewId) {
        return (T) activity.findViewById(viewId);
    }
}
```

```java
public class Apt {
    private Apt() {
        throw new AssertionError("No instances.");
    }

    public final static Unbinder bind(Activity activity) {
        String viewBindingClassName = activity.getClass().getName() + "_ViewBinding";
        try {
            Class<? extends Unbinder> viewBindingClass = (Class<? extends Unbinder>) Class.forName(viewBindingClassName);
            Constructor<? extends Unbinder> viewBindingConstructor = viewBindingClass.getDeclaredConstructor(activity.getClass());
            Unbinder unbinder = viewBindingConstructor.newInstance(activity);
            return unbinder;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Unbinder.EMPTY;
    }
}
```







Android library极其简单！



























# 遇到的问题



## 问题1，Java 库怎么引用sdk的东西呢？

```java
@Retention(RUNTIME) @Target(FIELD)
public @interface BindView {
  /** View ID to which the field will be bound. */
  @IdRes int value();
}	
```

我们看到ButterKnife中@IdRes是adk中的Android 注解。Java库中是处在Jdk环境中的，怎么才能引用到需要的sdk呢？

答案在这，需要在build文件中配置

```java

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    //runtime  这个去掉好像也可以
    compileOnly "com.google.android:android:4.1.1.4"
    api  "androidx.annotation:annotation:1.0.0"
}
```





## 问题2，如果中文乱码



```java
tasks.withType(JavaCompile){
    options.encoding='UTF-8'
}
```





## 问题3，AutoService注解无法生成META-INF文件

https://blog.csdn.net/cpcpcp123/article/details/103871815

由于Gradle 5.0将忽略compile classpath中的 annotationProcessor，因此需要手动添加annotationProcessor 'com.google.auto.service:auto-service:1.0-rc6'到 annotation processor path 如下： 

```java

Compile module 下的build文件 
implementation 'com.google.auto.service:auto-service:1.0-rc6'
    //之前这条是不用添加的
annotationProcessor 'com.google.auto.service:auto-service:1.0-rc6'
```












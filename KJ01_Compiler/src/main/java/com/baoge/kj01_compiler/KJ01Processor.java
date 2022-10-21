package com.baoge.kj01_compiler;

import androidx.annotation.CallSuper;

import com.baoge.kj01_annotation.BindView;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

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

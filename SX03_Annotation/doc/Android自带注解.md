![image-20221017194307371](Android%E8%87%AA%E5%B8%A6%E6%B3%A8%E8%A7%A3.assets/image-20221017194307371-16660069892201.png)





![image-20221017194344637](Android%E8%87%AA%E5%B8%A6%E6%B3%A8%E8%A7%A3.assets/image-20221017194344637-16660070265193.png)





我们举几个常见的例子：

资源限制类

@AnimatorRes ：animator资源类型
@AnimRes：anim资源类型
@AnyRes：任意资源类型
@ArrayRes：array资源类型
@AttrRes：attr资源类型
@BoolRes：boolean资源类型
@ColorRes：color资源类型
@DimenRes：dimen资源类型。
@DrawableRes：drawable资源类型。
@FractionRes：fraction资源类型
@IdRes：id资源类型
@IntegerRes：integer资源类型
@InterpolatorRes：interpolator资源类型
@LayoutRes：layout资源类型
@MenuRes：menu资源类型
@PluralsRes：plurals资源类型
@RawRes：raw资源类型
@StringRes：string资源类型
@StyleableRes：styleable资源类型
@StyleRes：style资源类型
@TransitionRes：transition资源类型
@XmlRes：xml资源类型
线程限制类

Thread annotations 线程执行限制类：用于限制方法或者类必须在指定的线程执行。如果方法代码运行线程和标注的线程不一致，则会导致警告。

@AnyThread
@BinderThread
@MainThread
@UiThread
@WorkerThread
数值限制类

Value Constraint Annotations 类型范围限制类：用于限制标注值的值范围

@FloatRang
@IntRange
@LayoutRes
这个是layout 资源类型，我们看一下 Activity 的 setContentView 源码：

```java
@Override
public void setContentView(@LayoutRes int layoutResID) {
    getDelegate().setContentView(layoutResID);
}
```

本质上，layoutResID 是一个 int 类型，如果不做限定的话，可以传入任意整形，但是有 @LayoutRes 注解的限制，值只能传入 R.layou.xx ， 如果传入其他的类型就会报错。举例如下：

需要注意的是，报错只是编译器的检查出错，提醒开发者改正错误用法，提前规避风险，并不影响编译运行

@MainThread
限定方法执行的线程，如果方法代码运行线程和标注的线程不一致，不会报错，更多是起一个提醒作用



```java
  @MainThread
   fun run() {

  }
```

@IntDef
IntDef 的源码如下：

 

```java
@Retention(SOURCE)
@Target({ANNOTATION_TYPE})
public @interface IntDef {
    /** Defines the allowed constants for this element */
    int[] value() default {};

    /** Defines whether the constants can be used as a flag, or just as an enum (the default) */
    boolean flag() default false;

    /**
     * Whether any other values are allowed. Normally this is
     * not the case, but this allows you to specify a set of
     * expected constants, which helps code completion in the IDE
     * and documentation generation and so on, but without
     * flagging compilation warnings if other values are specified.
     */
    boolean open() default false;
}

```

可以看到 Target 是 ANNOTATION_TYPE 说明 IntDef 是作用在注解上的。

还有一个 value 是 int数组。

下面我们定义一个注解 MOBILE_TYPE ， 并且用 IntDef 修饰，如下：

 

```java
import androidx.annotation.IntDef;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;

/**
 * @author : zhaoyanjun
 * @time : 2021/7/29
 * @desc :
 */
public class Util {

    public static final int TYPE_MI = 1;
    public static final int TYPE_MEIZU = 2;
    public static final int TYPE_HUAWEI = 3;

    @Retention(AnnotationRetention.SOURCE)
    @IntDef({TYPE_MI, TYPE_MEIZU, TYPE_HUAWEI})
    public @interface MOBILE_TYPE {
    }
    
    //使用
    public void doSomething(@MOBILE_TYPE int mobile){
        
    }
}

```

使用方法很简单，首先定义你需要的常量，然后用 @IntDef 包住这些常量，这样别人在使用你的方法时如果输入的值不在枚举的范围内，编译器就会给出提示了。

同理，@StringDef 也是同样的用法

 *  
 
 ```java
 import androidx.annotation.StringDef;
    
    import kotlin.annotation.AnnotationRetention;
    import kotlin.annotation.Retention;
 
    /**
     * @author : zhaoyanjun
     * @time : 2021/7/29
     * @desc :
  */
    public class Util {
 
        public static final String TYPE_HD = "720p";
     public static final String TYPE_SHD = "1080p";
     public static final String TYPE_FHD = "4k";
 
     @Retention(AnnotationRetention.SOURCE.SOURCE)
     @StringDef({TYPE_HD, TYPE_SHD, TYPE_FHD})
     public @interface DISPLAY_TYPE {
     }
 
     public void doSomething(@DISPLAY_TYPE String display) {
 
     }
 }
 ```

 还有一个 @LongDef也是同样的用法，这里就不举例了。

总结 ：IntDef @StringDef @LongDef 可以限制变量的类型，可以代替枚举类型

我们来看一个系统例子，Toast 的源码：

 

```java
  public static Toast makeText(Context context, CharSequence text, @Duration int duration) {
        return makeText(context, null, text, duration);
    }
```

@Duration 是一个自定义的注解：

```java

    /** @hide */
    @IntDef(prefix = { "LENGTH_" }, value = {
            LENGTH_SHORT,
            LENGTH_LONG
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface Duration {}
```

看到这里，我们已经很熟悉了，也是用的 @IntDef 注解，除此之外，我们还发现了一个细节 ，在 android 的注解包里，@IntDef 带有 prefix 属性，但是在 androidx 的注解包里却没有。

下面贴一下两个的源码，大家看看：

 

```java
//android 的源码，包名：android.annotation
@Retention(SOURCE)
@Target({ANNOTATION_TYPE})
public @interface IntDef {
    /** Defines the constant prefix for this element */
    String[] prefix() default {};
    /** Defines the constant suffix for this element */
    String[] suffix() default {};

    /** Defines the allowed constants for this element */
    int[] value() default {};

    /** Defines whether the constants can be used as a flag, or just as an enum (the default) */
    boolean flag() default false;
}

//androidx 的源码，包名：androidx.annotation
@Retention(SOURCE)
@Target({ANNOTATION_TYPE})
public @interface IntDef {
    /** Defines the allowed constants for this element */
    int[] value() default {};

    /** Defines whether the constants can be used as a flag, or just as an enum (the default) */
    boolean flag() default false;

    /**
     * Whether any other values are allowed. Normally this is
     * not the case, but this allows you to specify a set of
     * expected constants, which helps code completion in the IDE
     * and documentation generation and so on, but without
     * flagging compilation warnings if other values are specified.
     */
    boolean open() default false;
}
```

这是两个包下面的 IntDef 的差异，我想知道的是 prefix 有什么用?
其实也很简单，规范 value 数组元素的命名前缀。

@StringRes
这个其实很好理解，限制字符的来源，必须是 R.string.xx , StringRes 源码如下：

 * ```java
 /**
  * Denotes that an integer parameter, field or method return value is expected
  * to be a String resource reference (e.g. {@code android.R.string.ok}).
  */
 @Documented
 @Retention(CLASS)
 @Target({METHOD, PARAMETER, FIELD, LOCAL_VARIABLE})
 public @interface StringRes {
 }
 ```

 举个系统的例子：

 ```java
     public static Toast makeText(Context context, @StringRes int resId, @Duration int duration)
                                 throws Resources.NotFoundException {
         return makeText(context, context.getResources().getText(resId), duration);
        }
    ```
    
    **@ColorInt**
 限定颜色的取值范围 R.color.xx , 源码如下：

 * 

 * ```java
    /**
     * Denotes that the annotated element represents a packed color
     * int, {@code AARRGGBB}. If applied to an int array, every element
     * in the array represents a color integer.
     * <p>
     * Example:
     * <pre>{@code
     *  public abstract void setTextColor(@ColorInt int color);
     * }</pre>
     */
    @Documented
    @Retention(CLASS)
    @Target({PARAMETER, METHOD, LOCAL_VARIABLE, FIELD})
    public @interface ColorInt {
    }
    ```

    

 * 举个系统的例子：

 

```java
public void setTextColor(@ColorInt int color) {
    mTextColor = ColorStateList.valueOf(color);
    updateTextColors();
}
```

**@IdRes**
限制id 的取值范围：R.id.xx , 源码码如下：

 

```java
/**
 * Denotes that an integer parameter, field or method return value is expected
 * to be an id resource reference (e.g. {@code android.R.id.copy}).
 */
@Documented
@Retention(CLASS)
@Target({METHOD, PARAMETER, FIELD, LOCAL_VARIABLE})
public @interface IdRes {
}

```

举个系统的例子：

 

```java
 @Override
 public <T extends View> T findViewById(@IdRes int id) {
    return getDelegate().findViewById(id);
 }
```

**@DrawableRes**
限定资源的取值类型是一个 drawable 类型：android.R.attr.alertDialogIcon

 

```java
@Documented
@Retention(CLASS)
@Target({METHOD, PARAMETER, FIELD, LOCAL_VARIABLE})
public @interface DrawableRes {
}
```

举个系统的例子：

 

```java
public void setImageResource(@DrawableRes int resId) {
   ...
}							
```

**@NotNull**
定义个变量不能为空, 如果真的为空，不会影响编译，只是编译器会报错，提醒开发者注意。



```java
public class Util {

    //参数不能为null
    public void run(@NotNull String name) {

    }
}
```

测试：

![Android Annotation注解详解_Android_06](Android%E8%87%AA%E5%B8%A6%E6%B3%A8%E8%A7%A3.assets/resize,m_fixed,w_750-16660080380795.webp)

可以看到编译器会自动检查

**@Nullable**
限定一个参数，一个方法的返回值可以为null

 

```java
public class Util {

    @Nullable
    public String aa() {
        return null;
    }
}
```

使用：

 

**@Keep**
哪里不想被混淆就注解哪里。

 

```java
@Keep
public class Test {
}

public class TestA {
}
```

开始混淆打包，查看混淆后的结果：


我们发现TestA不见了而Test保留了下来，说明我们的配置起作用了，下面我们在Test 类中增加点内容看看混淆后会变成什么样子，修改后的类内容如下：

 


有没有很简单的感觉呢？哪里不混淆@Keep哪里，再也不用为混淆头疼了！

**@RequiresPermission**
限定字段，方法需要某个权限，如果没有，编译器会提醒

 

```java
public class Util1 {

@RequiresPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
public String run() {
    return null;
}
```

使用：

![Android Annotation注解详解_Android_12](Android%E8%87%AA%E5%B8%A6%E6%B3%A8%E8%A7%A3.assets/resize,m_fixed,w_750-16660082342256-16660082368818.webp)

看到编译器报错，我们点击一下 Add permission check , 编译器会自动帮我们补全代码

 

```java
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        Util1().run()
    }

}
```

@RequiresPermission(permision)
@RequiresPermission(allOf={permision1,perminsion2})
@RequiresPermission(anyOf={permision1,perminsion2})





**@Deprecated**
标记某个字段或者方法过时，举例：


**CallSuper**
子类重写某个方法时，要求调用super，可以使用该注解

**@IntRange**

```java
    //限定只能传1-4
    fun run(@IntRange(from = 1, to = 4) num: Int) {

    }
```

 

**@FloatRange**
用法上和 IntRange 一样， 



 

**@CheckResult**
假设你定义了一个方法返回一个值，你期望调用者用这个值做些事情，那么你可以使用@CheckResult注解标注这个方法，强制用户定义一个相应的返回值，使用它！

首先定义 CallSuperT ，定义一个retrunI方法返回一个int类型

```java
public class CallSuperT {

    @CheckResult
    public int retrunI(){
        return 1;
    }
}
```

正确调用：

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CallSuperT callSuperT = new CallSuperT();
        int returns = callSuperT.retrunI();
    }
}
```

如果这里去掉返回类型的定义对象：int returns则会抛出异常

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CallSuperT callSuperT = new CallSuperT();
        callSuperT.retrunI();
    }
}
```

错误提示结果：

![Android Annotation注解详解_赵彦军_16](Android%E8%87%AA%E5%B8%A6%E6%B3%A8%E8%A7%A3.assets/resize,m_fixed,w_750-16660085556689-166600855701211.webp)

**@size**
定义长度大小，可选择最小和最大长度使用

 

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testDo("");

        testDo("111");

        testDo("1");
    }

    private void testDo(@Size(min = 1,max = 2)String s){
        Log.e("tag","-------->"+s);
    }
}
```

错误提示结果：

![Android Annotation注解详解_Annotation_17](Android%E8%87%AA%E5%B8%A6%E6%B3%A8%E8%A7%A3.assets/resize,m_fixed,w_750-166600861867012-166600861990014.webp)

这里size定了一个最小和最大长度，所以只有testDo(“1”)符合条件，其他调用都抛出了异常

总结： 注解的作用：

**提高我们的开发效率**
**更早的发现程序的问题或者错误**
**更好的增加代码的描述能力**
**更加利于我们的一些规范约束**

 


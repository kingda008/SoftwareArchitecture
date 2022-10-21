Type体系的引入是对泛型的一种补偿。java泛型的引入为编译器提供了更严格的代码审查，但这些泛型信息在运行时将会被擦除，这将导致程序在运行期间无法获取到属性或者类的具体声明。Type的引入使得开发者在程序**运行期**内获取属性或者类的具体声明成为可能。

 **Type是一个接口，它的实现类如下图所示:**

![img](03_Java%E4%B8%ADrtti%E7%9A%84%E5%AE%9E%E7%8E%B0--Type%E7%B1%BB%E4%BB%8B%E7%BB%8D.assets/webp.webp)

从上图可以看出，Class类是继承了Type接口的，而Class类在反射中应用广泛，因此这很容易让我们想到Type的大多数应用应该也是在反射中。接下来看几个常见的实现接口。



## ParameterizedType（参数化类型）

带有泛型参数的属性声明都属于ParameterizedType，带有泛型参数的方法返回值类型也属于ParameterizedType



```java
public class A {
  //这几个属性都带泛型参数，因此都属于ParameterizedType
    private List<String> list;
    private Map<String, Integer> map;
    private Class<?> aClass;
    private Bean<String> bean;

  //该返回值类型属于ParameterizedType
    public List<String> getList() {
        return null;
    }
}
```

| 主要方法                         | 说明                                                         |
| -------------------------------- | ------------------------------------------------------------ |
| Type[] getActualTypeArguments(); | 返回这个 ParameterizedType 类型的参数的实际类型(即泛型)数组。 如 Map<String,Integer> map 这个 ParameterizedType 返回： [class java.lang.String, class java.lang.Integer] |
| Type getRawType();               | 返回的是当前这个 ParameterizedType 的类型的原型，如 Map<String,Integer> map 这个返回：interface java.util.Map |
| Type getOwnerType();             | 当这个变量类型为某个类的内部类并在声明时加入了泛型，这个方法返回其父类的Type。否者返回null |



```java
##定义类
public class A {
    private List<String> list;
    private Map<String, Integer> map;
    private Class<?> aClass;
    private Bean<String> bean;

    public class Bean<T> {

    }
}
  
##测试代码  
@Test
    public void test() throws IOException {
        Class c = A.class;
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            Type type = field.getGenericType();
            if (type instanceof ParameterizedType) {
                System.out.println(Arrays.toString(((ParameterizedType) type).getActualTypeArguments()));
                System.out.println(((ParameterizedType) type).getRawType());
                System.out.println(((ParameterizedType) type).getOwnerType());
            }
            System.out.println("====================================");
        }
    }
    
##输出
list
[class java.lang.String]
interface java.util.List
null
====================================
map
[class java.lang.String, class java.lang.Integer]
interface java.util.Map
null
====================================
aClass
[?]
class java.lang.Class
null
====================================
bean
[class java.lang.String]
class com.lu.test.A$Bean
class com.lu.test.A
====================================   
```



## TypeVariable

在类或者接口声明的时候添加泛型，那么这个类的泛型就属于TypeVariable

```java
//A类声明了2个泛型，即两个TypeVariable 
public class A<T extends String, E>	
```

| 主要方法                   | 说明                                                         |
| -------------------------- | ------------------------------------------------------------ |
| Type[] getBounds();        | 如果声明的泛型使用了extends  那么返回继承和实现的类和接口，例如泛型声明<T extends String&Serializable> 所对应的getBounds()返回：[class java.lang.String, interface java.io.Serializable] |
| D getGenericDeclaration(); | 返回声明该TypeVariable （即泛型）的类，例如上述代码返回的就是A类的GenericDeclaration； |

```java
##声明类
public class A<T extends String & Serializable, E> {
}
##测试代码
  @Test
    public void test() throws IOException {
        Class c = A.class;
        Type[] types = c.getTypeParameters();
        for (Type type : types) {
            System.out.println(type.getTypeName());
            if (type instanceof TypeVariable) {
                System.out.println(((TypeVariable) type).getGenericDeclaration());
                System.out.println(Arrays.toString(((TypeVariable) type).getBounds()));
            }
            System.out.println("==========================================");
        }
    }
##输出结果
T
class com.lu.test.A
[class java.lang.String, interface java.io.Serializable]
==========================================
E
class com.lu.test.A
[class java.lang.Object]
==========================================
```



## GenericArrayType

泛型数组,组成数组的元素中有范型 则属于GenericArrayType

```java
public class A<T> {
    T[] ts;//属于GenericArrayType
    List<String>[] lists;//属于GenericArrayType
   private String[] arr;
}
```



| 主要方法                        | 说明                                        |
| ------------------------------- | ------------------------------------------- |
| Type getGenericComponentType(); | 返回改数组类型元素的类型，例如T[] 返回的是T |

```java
##声明类
public class A<T> {
    T[] ts;
    List<String>[] lists;
}
##测试类
 @Test
    public void test() throws IOException {
        Class c = A.class;
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            Type type = field.getGenericType();
            if (type instanceof GenericArrayType) {
                System.out.println(((GenericArrayType) type).getGenericComponentType());
            }
            System.out.println("==================================");
        }
    }
##输出结果
T
==================================
java.util.List<java.lang.String>
==================================
```



## WildcardType 通配符的类型

形如<?> <? extends String> <? super Integer> 中的泛型(其实就是就是“？”)类型就属于WildcardType

```java
public class A {
    List<? extends String> ts;//属于WildcardType 
    List<?> list;//属于WildcardType 
    List<? super Integer> ins;//属于WildcardType 
}
```



| 主要方法                 | 说明                                                     |
| ------------------------ | -------------------------------------------------------- |
| Type[] getUpperBounds(); | 如果有extends 则返回的是extends对象的type 否则是[object] |
| Type[] getLowerBounds(); | 如果有super 则返回的是super 对象的type 否则是[]          |

```java
##声明类
public class A {
    List<? extends String> ts;
    List<?> list;
    List<? super Integer> ins;
}
##测试
 @Test
    public void test() throws IOException {
        Class c = A.class;
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            ParameterizedType type = (ParameterizedType) field.getGenericType();
            for (Type type1 : type.getActualTypeArguments()) {
                System.out.println("getTypeName():  " + type1.getTypeName());
                if (type1 instanceof WildcardType) {
                    System.out.println("getUpperBounds(): " + Arrays.toString(((WildcardType) type1).getUpperBounds()));
                    System.out.println("getLowerBounds(): " + Arrays.toString(((WildcardType) type1).getLowerBounds()));
                    System.out.println("===========================");
                }
            }
        }
    }



##输出结果
getTypeName():  ? extends java.lang.String
getUpperBounds(): [class java.lang.String]
getLowerBounds(): []
===========================
getTypeName():  ?
getUpperBounds(): [class java.lang.Object]
getLowerBounds(): []
===========================
getTypeName():  ? super java.lang.Integer
getUpperBounds(): [class java.lang.Object]
getLowerBounds(): [class java.lang.Integer]
===========================
```







上面介绍了四个比较常见的Type实现接口，它们在用法上有很大的区别。在区分的时候比较繁琐。不过大体上来说， ParameterizedType和GenericArrayType所修饰的是属性本身的类型，例如变量类型，方法返回值类型。而TypeVariable 和WildcardType 所修饰的是泛型类型，例如T，E或者？等。这一点一定要清楚。



 
链接：https://www.jianshu.com/p/bd4e5c779063
 
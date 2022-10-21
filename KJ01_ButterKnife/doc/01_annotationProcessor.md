### 前言：

  自从EventBus 3.x发布之后其通过注解预编译的方式解决了之前通过反射机制所引起的性能效率问题，其中注解预编译所采用的的就是android-apt的方式，不过最近Apt工具的作者宣布了不再维护该工具了，因为Android Studio推出了官方插件，并且可以通过gradle来简单的配置，它就是annotationProcessor，今天来学习一下如何将原来的android-apt切换到annotationProcessor。

### 什么是APT？

  APT(Annotation Processing Tool)是一种处理注释的工具,它对源代码文件进行检测找出其中的Annotation，使用Annotation进行额外的处理。 Annotation处理器在处理Annotation时可以根据源文件中的Annotation生成额外的源文件和其它的文件(文件具体内容由Annotation处理器的编写者决定),APT还会编译生成的源文件和原来的源文件，将它们一起生成class文件。

### 使用背景：

 随着Android Gradle 插件 2.2 版本的发布，Android Gradle 插件提供了名为 `annotationProcessor` 的功能来完全代替 `android-apt` ，自此`android-apt` 作者在官网发表声明证实了后续将不会继续维护 `android-apt` ，并推荐大家使用 Android 官方插件annotationProcessor。

### 切换步骤：

首先要确保Android Gradle插件版本是2.2以上，目前我们所使用的Android studio版本是2.2.3，所对应的的Android Gradle版本也是2.2.3

#### 1.）修改Project 的build.gradle配置

android-apt方式

```java
  dependencies {
        classpath 'com.android.tools.build:gradle:2.2.3'
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
    }
```

修改后`annotationProcessor` 方式

```java
  dependencies {
        classpath 'com.android.tools.build:gradle:2.2.3'
    }
```

#### 2.）修改module的build.gradle配置

android-apt方式



```java
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
    }
}
apply plugin: 'com.neenbedankt.android-apt'
dependencies {
    compile 'org.greenrobot:eventbus:3.0.0'
    apt'org.greenrobot:eventbus-annotation-processor:3.0.1'//apt
}
```

修改后`annotationProcessor` 方式，只保留dependencies 里面的引用并且把apt 换成annotationProcessor就可以了

```java
dependencies {
    compile 'org.greenrobot:eventbus:3.0.0'
    annotationProcessor  'org.greenrobot:eventbus-annotation-processor:3.0.1'
}
```

#### 3.）对EventBus 3.0 使用索引的兼容

android-apt方式

```java
apt  {
    arguments {
        eventBusIndex "org.greenrobot.eventbusperf.MyEventBusIndex"
    }
}
```

修改后`annotationProcessor` 方式



```java
defaultConfig {
        applicationId "com.whoislcj.testhttp"
        minSdkVersion 21
        targetSdkVersion 24
        versionCode 1
        versionName "1.0"
        jackOptions {
            enabled true
        }
        javaCompileOptions {
            annotationProcessorOptions {
                arguments = [ eventBusIndex : 'org.greenrobot.eventbusperf.MyEventBusIndex' ]
            }
        }
    }
```



### 两者对比

  最近Android N的发布，android 迎来了Java 8，要想使用Java 8的话必须使用Jack编译，android-apt只支持javac编译而annotationProcessor既支持javac同时也支持jack编译。

### 总结：

  今天只是简单的学习了从android-apt如何很好的切换到annotationProcessor，接下来将用annotationProcessor实战一下自己实现类似Butterknife注解框架。
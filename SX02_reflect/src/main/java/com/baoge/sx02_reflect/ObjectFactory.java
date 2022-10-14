package com.baoge.sx02_reflect;

public class ObjectFactory {
    public static <T> T getInstance(Class<T> cls) {

        try {
            // 返回使用该Class对象创建的实例
            return cls.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}

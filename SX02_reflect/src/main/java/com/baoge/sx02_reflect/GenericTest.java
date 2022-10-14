package com.baoge.sx02_reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class GenericTest {
    private Map<String, Integer> score;
    private int a;
    private Man man;

    public static void main(String[] args)
            throws Exception {
        Class<GenericTest> clazz = GenericTest.class;
        Field f = clazz.getDeclaredField("score");
        pritn(f);

        f = clazz.getDeclaredField("a");
        pritn(f);

        f = clazz.getDeclaredField("man");
        pritn(f);
    }


    static void pritn(Field f) {
        System.out.println("***********************************");
        // 直接使用getType()取出Field类型只对普通类型的Field有效
        Class<?> a = f.getType();
        // 下面将看到仅输出java.util.Map
        System.out.println("score的类型是:" + a);
        // 获得Field实例f的泛型类型
        Type gType = f.getGenericType();
        // 如果gType类型是ParameterizedType对象
        if (gType instanceof ParameterizedType) {
            // 强制类型转换
            ParameterizedType pType = (ParameterizedType) gType;
            // 获取原始类型
            Type rType = pType.getRawType();
            System.out.println("原始类型是： " + rType);
            // 取得泛型类型的泛型参数
            Type[] tArgs = pType.getActualTypeArguments();
            System.out.println("泛型类型是:");
            for (int i = 0; i < tArgs.length; i++) {
                System.out.println("第" + i + "个泛型类型是： " + tArgs[i]);
            }
        } else {
            System.out.println("获取泛型类型出错！ ");
        }
    }
}
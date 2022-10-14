package com.baoge.sx02_reflect;

import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Client {
    public static void main(String[] args) {

        Class manCls = Man.class;
        Method[] allMethods = manCls.getDeclaredMethods();//获取class对象的所有声明方法
        Method[] methods  = manCls.getMethods();//获取class对象的所有public方法 包括父类的方法
        try {
//            Method method = manCls.getMethod("info", String.class);//返回次Class对象对应类的、 带指定形参列表的public方法
//            Method declaredMethod = manCls.getDeclaredMethod("info", String.class);//返回次Class对象对应类的、 带指定形参列表的方法
        } catch (Exception e) {
            e.printStackTrace();
        }

        Field[] allFields = manCls.getDeclaredFields();//获取class对象的所有属性
        Field[] publicFields = manCls.getFields();//获取class对象的public属性


        System.out.println("*********** allMethods ****************** " );
        logMethod(allMethods);

        System.out.println("*********** methods ****************** " );

        logMethod(methods);

        System.out.println("*********** allFields ****************** " );

        logField(allFields);
        System.out.println("*********** publicFields ****************** " );

        logField(publicFields);


        Man man2 = ObjectFactory.getInstance(Man.class);
    }

    private static void logMethod(Method[] methods) {
        if (methods != null && methods.length > 0) {
            for(Method method:methods){

                System.out.println("method name: "+method.getName());
            }

        }else {
            System.out.println("NO VALID");
        }

    }


    private static void logField(Field[] fields) {
        if (fields != null && fields.length > 0) {
            for(Field field:fields){

                System.out.println("field name: "+field.getName());
            }

        }else {
            System.out.println("NO VALID");
        }

    }
}

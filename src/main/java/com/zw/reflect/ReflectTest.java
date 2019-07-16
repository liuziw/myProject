package com.zw.reflect;

import ch.qos.logback.core.status.OnPrintStreamStatusListenerBase;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liuzw
 * @email liuzw1@hua-cloud.com.cn
 * @date 2019/5/17 10:50
 */
public class ReflectTest {

    public static void main(String [] args) throws Exception {
        Class classType = ExtendType.class;
        //获取公共属性（包括父类的）
        Field [] fields = classType.getFields();
        for(Field field:fields){
            System.out.println("field:"+field);
        }
        System.out.println();
        //获取所有属性
        fields = classType.getDeclaredFields();
        for(Field field:fields){
            System.out.println("field:"+field);
        }
        System.out.println();

        //获取公共方法（包括父类的）
        Method [] methods = classType.getMethods();
        for(Method method:methods){
            System.out.println("method"+method);
        }
        System.out.println();
        //获取所有方法
        methods = classType.getDeclaredMethods();
        for(Method method:methods){
            System.out.println("method"+method);
        }
        System.out.println();

        //获取构造方法（不包括父类的）
        Constructor [] constructors = classType.getConstructors();
        for(Constructor constructor:constructors){
            System.out.println("构造方法"+constructor);
        }
        System.out.println();
        constructors = classType.getDeclaredConstructors();
        for(Constructor constructor:constructors){
            System.out.println("构造方法"+constructor);
        }
        System.out.println();

        //新建类的实例
        //1、调用类的Class对象的newInstance方法，该方法会调用对象的默认构造器，如果没有默认构造器，会调用失败.
        Object inst = classType.newInstance();
        System.out.println("实例"+inst);
        //2、调用默认Constructor对象的newInstance方法
        Constructor constructor = classType.getConstructor();
        Object inst2 = constructor.newInstance();
        System.out.println("实例"+inst2);
        //3、调用带参数Constructor对象的newInstance方法
        Constructor constructor1 = classType.getDeclaredConstructor(int.class,String.class);
        Object inst3 = constructor1.newInstance(1,"2");
        System.out.println("实例"+inst3);
        System.out.println();

        //调用类的函数
        Object object = classType.newInstance();
        Method logMethod = classType.getDeclaredMethod("log",String.class);
        logMethod.setAccessible(true);
        logMethod.invoke(object,"test-------");
        System.out.println();

        //设置/获取类的属性值
        Object object1 = classType.newInstance();
        Field field = classType.getField("pubIntExtendField");
        field.set(object1,1111);
        Object value = field.get(object1);
        System.out.println("属性值"+value);
        System.out.println();
    }

}

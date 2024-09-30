package com.example.springbootlearn.controller;

import com.example.springbootlearn.annotate.AnnotateOne;

import java.lang.reflect.Method;

/**
 * @author linW2
 * @date 2024/9/30 17:48
 * @description TODO: 自定义注解测试
 */
public class Test4 {

    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.example.springbootlearn.controller.Test3");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                AnnotateOne annotateOne = method.getAnnotation(AnnotateOne.class);
                if (annotateOne != null) {
                    System.out.println(annotateOne.value());
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

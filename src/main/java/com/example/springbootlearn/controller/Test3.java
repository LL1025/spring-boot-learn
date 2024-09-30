package com.example.springbootlearn.controller;

import com.example.springbootlearn.annotate.AnnotateOne;

import java.lang.reflect.Method;

/**
 * @author linW2
 * @date 2024/9/30 17:43
 * @description TODO: 描述类的功能
 */

public class Test3 {

    @AnnotateOne("这是一个自定义注解哦")
    public void annotateOneTest(){
        System.out.println("测试一下自定义注解哦");
    }

}
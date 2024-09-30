package com.example.springbootlearn.annotate;

import java.lang.annotation.*;

/**
 * @author linW2
 * @date 2024/9/30 17:39
 * @description TODO: 描述类的功能
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnnotateOne {

    String value() default "";
}

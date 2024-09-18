package com.example.springbootlearn.Do;

import lombok.Data;

import java.io.Serializable;

/**
 * @author linW2
 * @date 2024/9/14 11:46
 * @description TODO: 描述类的功能
 */
@Data
public class UserDO implements Serializable {

    String name;

    Integer age;

//    public UserDO(String name, Integer age) {
//        this.name = name;
//        this.age = age;
//    }
}

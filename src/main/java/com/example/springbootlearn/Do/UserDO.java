package com.example.springbootlearn.Do;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linW2
 * @date 2024/9/14 11:46
 * @description TODO: 描述类的功能
 */
@Data
@TableName("user")
public class UserDO implements Serializable {

    String userName;

    Integer userAge;

//    public UserDO(String name, Integer age) {
//        this.name = name;
//        this.age = age;
//    }
}

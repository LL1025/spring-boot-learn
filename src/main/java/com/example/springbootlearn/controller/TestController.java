package com.example.springbootlearn.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootlearn.Do.UserDO;
import com.example.springbootlearn.jdbc.ThreadJdbc;
import com.example.springbootlearn.service.AopService;
import com.example.springbootlearn.service.MyBatisPlusService;
import com.example.springbootlearn.service.ThreadLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;

/**
 * @author linW2
 * @date 2024/9/14 11:55
 * @description TODO: 描述类的功能
 */
@RestController
@RequestMapping(value = "controller")
public class TestController {

    @Autowired
    private AopService aopService;
    @Autowired
    private ThreadLocalService threadLocalService;

    private final MyBatisPlusService myBatisPlusService;

    public TestController(MyBatisPlusService myBatisPlusService){
        this.myBatisPlusService = myBatisPlusService;
    }

    @PostMapping("/aop/test")
    public void aopTest() {
        UserDO userDO = new UserDO();
        userDO.setUserAge(18);
        userDO.setUserName("张三");
        aopService.testAop(userDO);
    }

    @PostMapping("/threadLocal/test")
    public JSONObject threadLocalTest() {
        UserDO userDO = new UserDO();
        userDO.setUserAge(18);
        userDO.setUserName("张三");
        return threadLocalService.testThreadLocal(userDO);
    }

    @PostMapping("/mybatisPlus/test")
    public void mybatisPlusTest() {
        UserDO userDO = new UserDO();
        userDO.setUserAge(18);
        userDO.setUserName("张三");
        myBatisPlusService.inserUserAndClass();
    }

    public static void main(String[] args) {
        Connection connection = ThreadJdbc.getConnection();
        if (connection != null) {
            System.out.println("数据库连接成功");
            ThreadJdbc.closeConnection();
        }

    }
}

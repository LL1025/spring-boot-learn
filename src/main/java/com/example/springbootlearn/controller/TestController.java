package com.example.springbootlearn.controller;

import com.example.springbootlearn.Do.UserDO;
import com.example.springbootlearn.jdbc.ThreadJdbc;
import com.example.springbootlearn.service.AopService;
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

    @PostMapping("/aop/test")
    public void aopTest() {
        UserDO userDO = new UserDO();
        userDO.setAge(18);
        userDO.setName("张三");
        aopService.testAop(userDO);
    }

    @PostMapping("/threadLocal/test")
    public void threadLocalTest() {
        UserDO userDO = new UserDO();
        userDO.setAge(18);
        userDO.setName("张三");
        threadLocalService.testThreadLocal(userDO);
    }

    public static void main(String[] args) {
        Connection connection = ThreadJdbc.getConnection();
        if (connection != null) {
            System.out.println("数据库连接成功");

            ThreadJdbc.closeConnection();
        }

    }
}

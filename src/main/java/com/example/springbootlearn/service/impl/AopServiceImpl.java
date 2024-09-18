package com.example.springbootlearn.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.springbootlearn.Do.UserDO;
import com.example.springbootlearn.service.AopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author linW2
 * @date 2024/9/14 11:33
 * @description TODO: spring AOP测试
 */
@Service
@Slf4j
public class AopServiceImpl implements AopService {


    @Override
    public void testAop(UserDO userDO) {
        log.info(String.format("接口接收到的参数:%s", JSON.toJSON(userDO)));
    }
}

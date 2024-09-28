package com.example.springbootlearn.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootlearn.Do.UserDO;
import com.example.springbootlearn.service.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author linW2
 * @date 2024/9/14 12:21
 * @description TODO: 描述类的功能
 */
@Service
@Slf4j
public class ThreadLocalServiceImpl implements ThreadLocalService {
    @Override
    public JSONObject testThreadLocal(UserDO userDO) {
        ThreadLocal<UserDO> local = new ThreadLocal();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        final Object[] obj = {new Object()};
        executorService.execute(() -> {
            local.set(userDO);
            obj[0] = local.get();
            log.info(JSON.toJSONString(obj[0]));
        });
        return JSON.parseObject(JSON.toJSONString(obj[0]));
    }
}

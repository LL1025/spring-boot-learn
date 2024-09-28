package com.example.springbootlearn.service;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootlearn.Do.UserDO;

/**
 * @author linW2
 * @date 2024/9/14 12:22
 * @description TODO: ThreadLocal
 */
public interface ThreadLocalService {

    JSONObject testThreadLocal(UserDO userDO);
}

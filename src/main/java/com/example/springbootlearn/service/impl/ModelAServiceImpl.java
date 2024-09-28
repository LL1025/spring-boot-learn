package com.example.springbootlearn.service.impl;

import com.example.springbootlearn.service.ModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author linW2
 * @date 2024/9/28 14:47
 * @description TODO: 策略A
 */
@Service
@Slf4j
public class ModelAServiceImpl implements ModelService {

    private final String logPre = "策略A";
    @Override
    public void sendReturn(String param) {
        log.info(String.format("%s------%s", logPre, param));
    }
}

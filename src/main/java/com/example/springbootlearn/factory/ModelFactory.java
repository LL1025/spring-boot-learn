package com.example.springbootlearn.factory;

import com.example.springbootlearn.service.ModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author linW2
 * @date 2024/9/28 14:56
 * @description TODO: 描述类的功能
 */
@Component
@Slf4j
public class ModelFactory implements ApplicationContextAware {

    private static Map<String, ModelService> modelServiceMap = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        modelServiceMap = applicationContext.getBeansOfType(ModelService.class);
        log.info(String.format("策略工厂:%s", modelServiceMap));
    }

    public static ModelService getModelService(String key) {
        ModelService testStrategy = modelServiceMap.get(key);
        return testStrategy;
    }
}

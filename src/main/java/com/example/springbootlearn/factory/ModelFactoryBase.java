package com.example.springbootlearn.factory;

import com.example.springbootlearn.service.ModelService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author linW2
 * @date 2024/9/28 15:48
 * @description TODO: 改造成抽象的
 */
@Component
public abstract class ModelFactoryBase implements ApplicationContextAware {

    protected  static Map<String, ModelService> modelServiceMap = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        modelServiceMap = applicationContext.getBeansOfType(ModelService.class);
    }

    public abstract ModelService getModelFactory(String modelName);
}

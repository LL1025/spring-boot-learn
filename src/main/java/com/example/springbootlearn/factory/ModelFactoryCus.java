package com.example.springbootlearn.factory;

import com.example.springbootlearn.service.ModelService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author linW2
 * @date 2024/9/28 15:51
 * @description TODO: 描述类的功能
 */
@Slf4j
@Component
public class ModelFactoryCus extends ModelFactoryBase {


    @Override
    public ModelService getModelFactory(String modelName) {
        ModelService modelService = modelServiceMap.get(modelName);
        log.info(String.format("获取到的释放方法时:%s", modelServiceMap.get(modelName)));
        return modelService;
    }
}

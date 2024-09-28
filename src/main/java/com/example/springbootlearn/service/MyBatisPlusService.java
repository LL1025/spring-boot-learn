package com.example.springbootlearn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootlearn.Do.UserDO;
import org.springframework.stereotype.Component;

/**
 * @author linW2
 * @date 2024/9/26 13:37
 * @description TODO: 描述类的功能
 */
@Component
public interface MyBatisPlusService extends IService<UserDO> {

    void inserUserAndClass();
}

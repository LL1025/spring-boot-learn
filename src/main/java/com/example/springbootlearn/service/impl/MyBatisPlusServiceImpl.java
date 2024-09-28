package com.example.springbootlearn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootlearn.Do.ClassDO;
import com.example.springbootlearn.Do.UserDO;
import com.example.springbootlearn.mapper.ClassMapper;
import com.example.springbootlearn.mapper.UserMapper;
import com.example.springbootlearn.service.MyBatisPlusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author linW2
 * @date 2024/9/26 13:38
 * @description TODO: 描述类的功能
 */
@Service
@Slf4j
public class MyBatisPlusServiceImpl extends ServiceImpl<UserMapper, UserDO> implements MyBatisPlusService {

    private final UserMapper userMapper;

    private final ClassMapper classMapper;

    public MyBatisPlusServiceImpl(UserMapper userMapper, ClassMapper classMapper) {
        this.userMapper = userMapper;
        this.classMapper = classMapper;
    }

    @Override
    public void inserUserAndClass() {
        UserDO userDO = new UserDO();
        userDO.setUserAge(24);
        userDO.setUserName("laocheng");
        baseMapper.insert(userDO);

        try {
            this.inserClass();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void inserClass(){
        ClassDO classDO = new ClassDO();
        classDO.setClassName("姚班");
        classDO.setClassDesc("巨牛逼");
        classMapper.insert(classDO);
        throw new RuntimeException(String.format("测试一下Spring的事务传播特性"));
    }
}

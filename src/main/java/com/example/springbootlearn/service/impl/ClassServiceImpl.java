package com.example.springbootlearn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootlearn.Do.ClassDO;
import com.example.springbootlearn.mapper.ClassMapper;
import com.example.springbootlearn.service.ClassService;
import org.springframework.stereotype.Service;

/**
 * @author linW2
 * @date 2024/9/26 14:18
 * @description TODO: 描述类的功能
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, ClassDO> implements ClassService {
}

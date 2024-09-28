package com.example.springbootlearn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootlearn.Do.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author linW2
 * @date 2024/9/26 13:31
 * @description TODO: 描述类的功能
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

}

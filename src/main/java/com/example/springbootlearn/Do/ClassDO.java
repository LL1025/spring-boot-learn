package com.example.springbootlearn.Do;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author linW2
 * @date 2024/9/26 14:08
 * @description TODO: 描述类的功能
 */
@Data
@TableName("class")
public class ClassDO implements Serializable {

    private String ClassName;

    private String ClassDesc;
}

package com.atguigu.crud.lombok;

import lombok.Data;

import java.util.Date;

/**
 * @author lhh
 * @date 2019/4/3 15:38
 * @Description: 测试lombok插件
 */
@Data
public class LombokDemo01 {
    private String name;
    private String sex;
    private Integer age;
    private Date createTime;

}

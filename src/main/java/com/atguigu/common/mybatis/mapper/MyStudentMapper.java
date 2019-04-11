package com.atguigu.common.mybatis.mapper;

import com.atguigu.common.mybatis.bean.MyStudent;

import java.util.List;

/**
 * @author lhh
 * @date 2019/4/11 17:23
 */
public interface MyStudentMapper {
    public List<MyStudent> findAll();
}

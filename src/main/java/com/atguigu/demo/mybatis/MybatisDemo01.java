package com.atguigu.demo.mybatis;

import com.atguigu.common.mybatis.bean.MyStudent;
import com.atguigu.common.mybatis.mapper.MyStudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lhh
 * @date 2019/4/11 17:21
 * @Description: 测试mybatis
 */
public class MybatisDemo01 {
    @Test
    public void fun1() throws IOException {
        String resource = "config/mybatis/mybatis-config1.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MyStudentMapper myStudentMapper = sqlSession.getMapper(MyStudentMapper.class);
        System.out.println("代理类:" + myStudentMapper);
        List<MyStudent> myStudentList = myStudentMapper.findAll();
        System.out.println("查询结果:" + myStudentList);
    }
}

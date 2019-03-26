package com.atguigu.common.pojo.annotation.repository;

import com.atguigu.common.pojo.annotation.AnnoDemo01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author lhh
 * @date 2019/3/24 22:54
 * @Description:
 */
@Repository(value = "userRepository")
public class TestUserRepositoryImpl implements TestUserRepository {
    public TestUserRepositoryImpl() {
        System.out.println("构造器，TestUserRepositoryImpl...");
    }

    @Autowired
    private AnnoDemo01 annoDemo01;

    @Override
    public void save() {
        System.out.println("TestUserRepository 的save方法...");
    }
}

package com.atguigu.common.pojo.annotation.service;

import com.atguigu.common.pojo.annotation.repository.TestUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lhh
 * @date 2019/3/24 22:56
 * @Description:
 */
@Service
public class TestUserService {

    public TestUserService() {
        System.out.println("构造器，TestUserService...");
    }

    @Autowired
    private TestUserRepository userRepository;

    public void add() {
        System.out.println(" UserService add方法...");
        userRepository.save();
    }
}

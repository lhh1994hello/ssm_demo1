package com.atguigu.common.pojo.annotation.service;

import com.atguigu.common.pojo.annotation.repository.TestUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    //    @Autowired
//    @Qualifier(value = "testUserRepositoryImpl")
    private TestUserRepository userRepository;

    @Autowired
    //@Qualifier(value = "testUserJdbcRepositoryImpl")
    public void setUserRepository( TestUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void add() {
        System.out.println(" UserService add方法...");
        userRepository.save();
    }
}

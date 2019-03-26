package com.atguigu.common.pojo.annotation.repository;

import org.springframework.stereotype.Repository;

/**
 * @author lhh
 * @date 2019/3/24 23:39
 * @Description:
 */
@Repository
public class TestUserJdbcRepositoryImpl implements TestUserRepository {
    @Override
    public void save() {
        System.out.println("TestUserJdbcRepository 的save方法...");
    }
}

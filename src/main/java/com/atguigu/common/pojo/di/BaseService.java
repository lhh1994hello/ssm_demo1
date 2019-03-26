package com.atguigu.common.pojo.di;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 泛型依赖注入
 *
 * @param <T>
 */
public class BaseService<T> {

    @Autowired
    protected BaseRepository<T> repository;

    public void add() {
        System.out.println("add...");
        System.out.println(repository);
    }

}

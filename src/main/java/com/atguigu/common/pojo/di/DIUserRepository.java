package com.atguigu.common.pojo.di;

import org.springframework.stereotype.Repository;

@Repository
public class DIUserRepository extends BaseRepository<DIUser> {
    public DIUserRepository() {
        System.out.println("DIUserRepository构造器...");
    }
}

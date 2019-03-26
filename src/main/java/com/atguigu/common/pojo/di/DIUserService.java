package com.atguigu.common.pojo.di;

import org.springframework.stereotype.Service;

@Service
public class DIUserService extends BaseService<DIUser> {
    public DIUserService() {
        System.out.println("DIUserService构造器...");
    }
}

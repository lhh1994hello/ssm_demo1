package com.atguigu.common.pojo.aop.aspect.user;

/**
 * @author lhh
 * @date 2019/3/29 14:45
 * @Description:
 */
public interface IUser {
    public String findUser(String username);
    public void addUser(String username);
    public void findAll();
}

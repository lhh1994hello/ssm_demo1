package com.atguigu.common.pojo.aop.aspect.user;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lhh
 * @date 2019/3/29 14:46
 * @Description:
 */
public class IUserImpl implements IUser {
    public static Map map = null;

    public static void init() {
        String[] list = {"Lucy", "Tom", "小明", "Smith", "Hello"};
        Map tmp = new HashMap();
        for (int i = 0; i < list.length; i++) {
            tmp.put(list[i], list[i] + "00");
        }
        map = tmp;
    }

    public void addUser(String username) {
        init();
        map.put(username, username + "11");
        System.out.println("--------------【addUser】: " + username + " --------------");
        System.out.println("【The new List:" + map + "】");
    }

    public void findAll() {
        init();
        System.out.println("---------------【findAll】: " + map + " ------------------");
    }

    public String findUser(String username) {
        init();
        String password = "没查到该用户";
        if (map.containsKey(username)) {
            password = map.get(username).toString();
        }
        System.out.println("-----------------【findUser】-----------------");
        System.out.println("-----------------Username:" + username + "-----------------");
        System.out.println("-----------------【Result】:" + password + "------------------");
        return password;

    }
}

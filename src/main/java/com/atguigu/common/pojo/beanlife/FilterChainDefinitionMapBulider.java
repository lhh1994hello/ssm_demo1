//创建时间：2018年5月2日,下午8:06:03
package com.atguigu.common.pojo.beanlife;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBulider {

    //该方法必须是非静态的
    public LinkedHashMap<String, String> bulidFilterChainDefinitionMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("/login.jsp", "anon");
        map.put("/shiro/login", "anon");
        map.put("/shiro/logout", "logout");

        map.put("/user.jsp", "authc,roles[user]");
        map.put("/admin.jsp", "authc,roles[admin]");
        map.put("/list.jsp", "user");
        map.put("/**", "authc");
        return map;
    }

}

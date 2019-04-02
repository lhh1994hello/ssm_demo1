package com.atguigu.se.collect.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author lhh
 * @date 2019/4/1 11:32
 * @Description:
 */
public class HashMapDemo01 {
    @Test
    public void fun1() {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> table = new Hashtable<String, Object>();
//        map.put(null, null);
//        table.put("s", null);
//        System.out.println(map);
//        System.out.println(table);
        map.put("a", "A");
        Object o = map.get("a");
        System.out.println(o);

    }
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}

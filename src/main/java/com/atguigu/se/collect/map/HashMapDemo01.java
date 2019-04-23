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
        String strTmp = "如鱼得水sd";
        map.put("a", "A");
        Object o = map.get("a");
        map.remove("a");
        System.out.println(o);

        int hashDemo = hashDemo(strTmp);
        int hashCode = strTmp.hashCode();
        System.out.println("hash值:" + hashDemo);
        System.out.println("哈希码:" + Integer.toBinaryString(hashCode).length() + ":" + Integer.toBinaryString(hashCode));

        double pow = Math.pow(2, 16);
        System.out.println("次方：" + pow);
        int i2 = 774889 >>> 16;
        System.out.println("" + i2);
        int i3 = 774889 ^ 709353;
        System.out.println("异或运算：" + i3);

        int andValue = 10 & 127;
        System.out.println("andValue:"+andValue);


    }

    static final int hashDemo(Object key) {
        int h = 0;
        int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        System.out.println("key的hashcode:" + key.hashCode());
        System.out.println("右移之后：" + (h >>> 16));
        int i = 774889 ^ 11;
        System.out.println("异或运算了：" + i);
        return hash;
    }


}

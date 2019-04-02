package com.atguigu.se.foundation.str;

import org.junit.Test;

import com.atguigu.common.pojo.Car;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//作者:lhh 创建时间:2019年3月29日 上午8:52:31 

/**
 * @author lhh equals和==测试
 */
public class EqualsDemo01 {
    // equal比较是否是同一个对象，即比较内存地址
    // ==,对于基本数据类型直接比较数据本身，对于引用数据类型，比较内存地址，和equals相同
    @Test
    public void fun1() {
        Car c1 = new Car();
        Car c2 = new Car();

        Car c3 = c1;
        System.out.println(c1 == c2);
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
        System.out.println("c1的哈希码:" + c1.hashCode());
        System.out.println("c2的哈希码:" + c2.hashCode());
        System.out.println("c3的哈希码:" + c3.hashCode());

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("a", "A");
        String str = new String("ABC");
        boolean equals = str.equals(c1);

        int hashCode = str.hashCode();
        System.out.println("字符哈希:" + hashCode);

    }

    @Test
    public void fun2() {
        HashSet<StringBuilder> hs = new HashSet<StringBuilder>();
        StringBuilder sb1 = new StringBuilder("aaa");
        StringBuilder sb2 = new StringBuilder("aaabbb");
        hs.add(sb1);
        hs.add(sb2);    //这时候HashSet里是{"aaa","aaabbb"}
        System.out.println("A:" + hs);
        StringBuilder sb3 = sb1;
        sb3.append("bbb");  //这时候HashSet里是{"aaabbb","aaabbb"}
        System.out.println("B:" + hs);
        System.out.println("--------------------------------");
        HashMap<StringBuilder, Object> hashMap = new HashMap<>();

        StringBuilder stb1 = new StringBuilder("cc");
        StringBuilder stb2 = new StringBuilder("ccdd");

        hashMap.put(stb1, "AAA");
        hashMap.put(stb2, "BBB");
        System.out.println("测试1:" + hashMap);
        stb1.append("dd");
        System.out.println("测试2:" + hashMap);

    }
}

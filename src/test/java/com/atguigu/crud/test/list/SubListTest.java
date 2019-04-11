package com.atguigu.crud.test.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhh
 * @date 2019/4/11 9:47
 * @Description:
 */
public class SubListTest {
    @Test
    public void fun1() {
        List<String> helloList = new ArrayList<>();
        helloList.add("a");
        helloList.add("b");
        helloList.add("c");
        List<String> subList = helloList.subList(0, helloList.size());
        //强转失败，java.lang.ClassCastException: java.util.ArrayList$SubList cannot be cast to java.util.ArrayList
        ArrayList<String> arrayList= (ArrayList<String>) subList;

    }
}

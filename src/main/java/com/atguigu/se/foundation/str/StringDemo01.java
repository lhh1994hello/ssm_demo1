package com.atguigu.se.foundation.str;

/**
 * @author lhh
 * @date 2019/4/1 10:13
 * @Description: 重写String的equals方法
 */
public class StringDemo01 {

    private char value[];


    public StringDemo01(String str) {
        value = str.toCharArray();
    }

    //重写String的equals方法.
    @Override
    public boolean equals(Object anObject) {
        //如果和自身比较，直接返回true
        if (this == anObject) {
            return true;
        }
        //如果对象不是字符类型的
        if (!(anObject instanceof StringDemo01)) {
            return false;
        }
        //对象是字符串类型的
        StringDemo01 anObjectStr = (StringDemo01) anObject;
        int n = value.length;
        //如果长度不相等，就直接返回false
        if (n != anObjectStr.value.length) {
            return false;
        }
        char[] var1 = value;
        char[] var2 = anObjectStr.value;
        int i = 0;
        while (n-- != 0) {
            if (var1[i] != var2[2]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        StringDemo01 demo01 = new StringDemo01("ABD");
        StringDemo01 demo02 = new StringDemo01("ABC");
        boolean equals = demo01.equals(demo02);

        System.out.println(equals);
    }
}

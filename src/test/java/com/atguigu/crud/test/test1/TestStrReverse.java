package com.atguigu.crud.test.test1;

import org.junit.Test;

//作者:lhh 创建时间:2019年1月24日 上午10:48:45 
/**
 * 字符反转  示例输入："abc-1de/fg" 输出："cba-1ed/gf"
 * 
 * @author lhh
 *
 */
@SuppressWarnings("all")
public class TestStrReverse  { 
	// 大写字母:65-90,小写字母:97-122
	@Test
	public void fun1() {
		StringBuffer sbf = new StringBuffer();// 保存结果
		String str = "#￥%abc-1de/fg@^";//测试数据
		char[] charArray = str.toCharArray();
		StringBuffer sub = new StringBuffer();// 保存连续字母
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {// 是字母			
				sub.append(c);
				if (i == charArray.length - 1) {
					sbf.append(reverseSubStr(sub.toString()));
				}
			} else {// 不是字母	
				sbf.append(reverseSubStr(sub.toString()));
				sub.delete(0, sub.length());//清空上次的字母字符串，重新记录
				sbf.append(c);//非字母字符直接放到结果集中
			}
		}
		System.out.println("反转后的字符:" + sbf.toString());
	}
	// 子字符串翻转
	private String reverseSubStr(String str) {
		if ((str == null) || str.length() < 2) {return str;}	
		return reverseSubStr(str.substring(1)) + str.charAt(0);
	}
}

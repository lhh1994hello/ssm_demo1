package com.atguigu.crud.test2;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import com.atguigu.crud.pt.TbUser;
import com.atguigu.crud.pt.TbUserVO;

/**
 * BeanUtils的使用
 * 
 * @author lhh
 *
 */
public class BeanUtilTest {

	@Test
	public void fun1() {
		TbUser user = new TbUser("张三", "123", "男", new Date());
		TbUserVO userVO = new TbUserVO();
		System.out.println(user);
		System.out.println(userVO);
		System.out.println("======================");
		BeanUtils.copyProperties(user, userVO);
		System.out.println(userVO);
	}
}

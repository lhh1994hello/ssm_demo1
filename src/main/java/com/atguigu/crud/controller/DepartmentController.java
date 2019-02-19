//创建时间：2018年3月12日,下午5:47:51
package com.atguigu.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.service.DepartmentService;
import com.atguigu.crud.util.Msg;

/**
 * 
 * @author 李红辉 处理和部门有关的信息
 */
@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departService;

	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDepartmentWithJson() {
		List<Department> departmentList = departService.getDepts();
		// 返回的是一个Map集合，自动转换成JSON串
		return Msg.Success().add("depts", departmentList);
	}
}

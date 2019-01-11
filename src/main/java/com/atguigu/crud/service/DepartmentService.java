//创建时间：2018年3月12日,下午5:49:38
package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.crud.bean.Department;
import com.atguigu.crud.dao.DepartmentMapper;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;
	//查询部门所有信息
	public List<Department> getDepts() {
		List<Department> departmentList = departmentMapper.selectByExample(null);
		return departmentList;
	}

}

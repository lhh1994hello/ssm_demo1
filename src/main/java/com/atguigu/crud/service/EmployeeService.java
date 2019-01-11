package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.EmployeeExample;
import com.atguigu.crud.bean.EmployeeExample.Criteria;
import com.atguigu.crud.dao.EmployeeMapper;

//业务层
@Service
public class EmployeeService {
	// 注入dao层依赖
	@Autowired
	private EmployeeMapper employeeMapper;

	/**
	 * 查询所有员工信息
	 * 
	 * @return
	 */
	public List<Employee> getAll() {
		List<Employee> employeeList = employeeMapper.selectByExampleWithDept(null);
		return employeeList;
	}

	// 员工保存方法
	public void saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);
	}

	// 检查用户名是否可用,返回true表示没有这个名字，可用
	public boolean checkUser(String empName) {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count = employeeMapper.countByExample(example);
		return count == 0;
	}

	//
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(email);
		long count = employeeMapper.countByExample(example);
		return count == 0;
	}

	// 根据id查询员工信息
	public Employee getEmp(Integer id) {
		// TODO Auto-generated method stub
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		return employee;
	}

	// 更新员工信息
	public void updateEmp(Employee employee) {
		// TODO Auto-generated method stub
		// 有选择地更新，带了哪个数据就更新哪个数据，名字不带就不更新名字
		employeeMapper.updateByPrimaryKeySelective(employee);
	}

	// 删除员工
	public void deleteEmpById(Integer empId) {
		// TODO Auto-generated method stub
		employeeMapper.deleteByPrimaryKey(empId);
	}

	// 批量删除
	public void deleteBatch(List<Integer> empId) {
		// TODO Auto-generated method stub
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpIdIn(empId);
		employeeMapper.deleteByExample(example);
	}

}

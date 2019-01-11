package com.atguigu.crud.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.bean.DataTableBean;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.service.EmployeeService;
import com.atguigu.crud.util.Msg;

//作者:lhh 创建时间:2018年11月23日 下午2:51:19 
@Controller
@RequestMapping("/dataTable")
public class DataTableController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/test1", method = RequestMethod.POST)
	@ResponseBody
	public Msg getTrafficMonitorFailedList(String[] param, String opportunityNO) {
		List<Employee> employeeList = employeeService.getAll();
		System.out.println("AAA:" + param);
		return Msg.Success().add("employeeList", employeeList);
	}
	
	@RequestMapping(value = "/test2")
	@ResponseBody
	public DataTableBean test2(String beginTime,String endTime){
		DataTableBean d=new DataTableBean(1,"AAA","BBB",new Date());
		System.out.println("---------------------------------");
		System.out.println("beginTime:"+beginTime+",endTime:"+endTime);
		System.out.println(d);
		return d;
	}
	
	@RequestMapping(value = "/test3")
	@ResponseBody
	public Msg test3(String columns ,String draw){
		DataTableBean d=new DataTableBean(1,"AAA","BBB",new Date());
		System.out.println("---------------------------------");
		System.out.println(columns);
		System.out.println("draw:"+draw);
 		System.out.println(d);
		OfficeBean officeBean1=new OfficeBean("1","1张三","技术员1","	New York1",32,new Date(),4600.0);
		OfficeBean officeBean2=new OfficeBean("1","2张三","技术员2","	New York2",33,new Date(),4700.0);
		OfficeBean officeBean3=new OfficeBean("1","3张三","技术员3","	New York3",134,new Date(),4800.0);
		OfficeBean officeBean4=new OfficeBean("1","4张三","技术员4","	New York4",335,new Date(),4900.0);
		OfficeBean officeBean5=new OfficeBean("1","5张三","技术员5","	New York5",636,new Date(),4000.0);
		
		List<OfficeBean> listOfficeBean=new ArrayList<>();
		listOfficeBean.add(officeBean1);
		listOfficeBean.add(officeBean2);
		listOfficeBean.add(officeBean3);
		listOfficeBean.add(officeBean4);
		listOfficeBean.add(officeBean5);
		listOfficeBean.add(officeBean1);
		listOfficeBean.add(officeBean2);
		listOfficeBean.add(officeBean3);
		listOfficeBean.add(officeBean4);
		listOfficeBean.add(officeBean5);
		System.out.println("333请求进来了。。"+new Date());
		return Msg.Success().add("listOfficeBean", listOfficeBean);
		
	}

}

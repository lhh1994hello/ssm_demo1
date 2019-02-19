package com.atguigu.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.service.EmployeeService;
import com.atguigu.crud.util.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	/*
	 * 以JSON字符串的形式，使用注解，会把return 的数据自动转成JSON数据
	 * 
	 * @ResponseBody：需要导入jackson包
	 */
	// 规定Post方式的请求是用来保存插入数据的(保存)
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	@ResponseBody
	// JSR303校验，@Valid savaEmp
	public Msg saveEmp(@Valid Employee employee, BindingResult result) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FieldError> errors = result.getFieldErrors();

		if (result.hasErrors()) {
			for (FieldError fieldError : errors) {
				System.out.println("错误的字段名：" + fieldError.getField());
				System.out.println("错误信息：" + fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);

		} else {
			System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA成功。。。。。。。。。。。。。。");
			employeeService.saveEmp(employee);
			return Msg.Success();
		}
	}

	@RequestMapping("/emps2")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		PageHelper.startPage(pn, 5);
		List<Employee> employeeList = employeeService.getAll();
		for (Employee employee : employeeList) {
			System.out.println("查询出来：" + employee);
		}

		PageInfo pageInfo = new PageInfo(employeeList, 5);
		System.out.println("############################################3");
		System.out.println("显示数据：" + Msg.Success().add("pageInfo", pageInfo));
		// return pageInfo;
		return Msg.Success().add("pageInfo", pageInfo);

	}

	/*
	 * 查询员工数据信息(分页显示)
	 */
	@RequestMapping("/emps")
	public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// 在查询之前只需要调用，传入页码以及每页显示的数据记录数
		// 为了分页,引入pageHepler,这个5表示每页显示5条记录
		PageHelper.startPage(pn, 5);
		List<Employee> employeeList = employeeService.getAll();
		System.out.println("#########################" + employeeList);
		for (Employee employee : employeeList) {
			System.out.println("查询出来：" + employee);
		}
		// 使用PageInfo包装查询后的结果，只需要将pageInfo交给页面就行了
		// pageInfo封装了详细的分页信息，包括我们查询出来的数据,5代表每次显示5页数据，就那个导航栏
		PageInfo pageInfo = new PageInfo(employeeList, 5);
		// 设置过了前缀和后缀，可以直接写简单的路径，
		// model会把数据带给页面，相当于放到域中
		model.addAttribute("pageInfo", pageInfo);

		return "list";
	}

	// 检验用户名是否可用
	@ResponseBody
	@RequestMapping(value = "/checkuser", method = RequestMethod.POST)
	public Msg checkUser(@RequestParam("empName") String empName) {
		String regex = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		if (!empName.matches(regex)) {
			return Msg.fail().add("va_msg", "后台校验_用户名可以是2-5位中文或者6-16位英文和数字的组合");
		}

		boolean b = employeeService.checkUser(empName);
		if (b) {
			// 还不存在
			return Msg.Success();
		} else {
			return Msg.fail().add("va_msg", "后台校验_用户名已存在");
		}
	}

	//
	// 检验邮箱是否可用
	@ResponseBody
	@RequestMapping(value = "/checkemail", method = RequestMethod.POST)
	public Msg checkEmail(@RequestParam("empName") String email) {
		String regex = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
		if (!email.matches(regex)) {
			return Msg.fail().add("va_msg", "后台校验_邮箱格式不正确111");
		}
		boolean b = employeeService.checkEmail(email);
		if (b) {
			// 还不存在
			return Msg.Success();
		} else {
			return Msg.fail().add("va_msg", "后台校验_邮箱已经被注册");
		}
	}

	// 查询员工、
	@ResponseBody
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
	// 这个id是从路径中取出来的
	public Msg getEmp(@PathVariable("id") Integer id) {
		Employee employee = employeeService.getEmp(id);
		return Msg.Success().add("emp", employee);
	}

	// 修改员工，put请求
	@RequestMapping(value = "/emp/{empId}", method = RequestMethod.PUT)
	@ResponseBody
	public Msg saveEmp(Employee employee) {
		System.out.println("将要更新的员工数据：" + employee);
		employeeService.updateEmp(employee);
		return Msg.Success();
	}

	// 删除/
	@ResponseBody
	@RequestMapping(value = "/emp/{empId}", method = RequestMethod.DELETE)
	public Msg deleteEmpById(@PathVariable("empId") String empId) {
		if (empId.contains("-")) {
			// 批量删除
			List<Integer> delete_ids = new ArrayList<Integer>();
			String[] str_empIds = empId.split("-");
			// 批量删除
			for (String string : str_empIds) {
				delete_ids.add(Integer.parseInt(string));
			}
			employeeService.deleteBatch(delete_ids);
		} else {
			// 删除单个
			Integer id = Integer.parseInt(empId);
			employeeService.deleteEmpById(id);

		}
		return Msg.Success();
	}

}

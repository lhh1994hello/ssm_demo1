package com.atguigu.crud.controller;

import java.io.Serializable;
import java.util.Date;

//作者:lhh 创建时间:2018年11月30日 上午10:21:05 
public class OfficeBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String username;
	private String position;
	private String office;
	private int age;
	private Date createTime;
	private double salary;

	public OfficeBean(String id, String username, String position, String office, int age, Date createTime,
			double salary) {
		super();
		this.id = id;
		this.username = username;
		this.position = position;
		this.office = office;
		this.age = age;
		this.createTime = createTime;
		this.salary = salary;
	}

	public OfficeBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "OfficeBean [id=" + id + ", username=" + username + ", position=" + position + ", office=" + office
				+ ", age=" + age + ", createTime=" + createTime + ", salary=" + salary + "]";
	}

}


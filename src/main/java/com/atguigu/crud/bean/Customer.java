package com.atguigu.crud.bean;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//作者:lhh 创建时间:2019年2月19日 上午11:00:01 
@XmlRootElement
public class Customer implements Serializable {

	private String name;

	private int age;

	private int id;

	private Date createTime;

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@XmlElement
	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	@XmlElement
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", id=" + id + ", createTime=" + createTime + "]";
	}

}

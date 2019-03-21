package com.atguigu.crud.test2;

import java.util.ArrayList;
import java.util.List;

//作者:lhh 创建时间:2019年3月7日 下午4:49:07 
public class ForTest {
	public static void main(String[] args) {
		List<AF> list = new ArrayList<AF>();
		AF a1 = new AF("a", "a");
		AF a2 = new AF("a", "a");
		AF a3 = new AF("a", "a");
		AF a4 = new AF("a", "a");
		AF test = null;
		list.add(a1);
		list.add(a2);
		list.add(test);
		list.add(a3);
		list.add(a4);

		for (AF af : list) {
			System.out.println(af);
			af.getName();
		}
	}
}

class AF {

	private String name;
	private String sex;

	public AF() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AF(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "AF [name=" + name + ", sex=" + sex + "]";
	}

}

package com.atguigu.common.pojo.beanlife;

//作者:lhh 创建时间:2019年3月27日 上午9:20:55 
public class BeanLife {
	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public BeanLife() {
		System.out.println("LifePojo无参构造器......");
	}

	public void init() {
		System.out.println("LifePojo的init方法......");
	}

	public void destroy() {
		System.out.println("LifePojo的destroy方法......");
	}

}

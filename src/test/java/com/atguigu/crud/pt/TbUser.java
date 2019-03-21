package com.atguigu.crud.pt;

import java.util.Date;

//作者:lhh 创建时间:2019年3月13日 下午3:00:46 
public class TbUser {
	private String username;
	private String password;
	private String sex;
	private Date birthday;

	public TbUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TbUser(String username, String password, String sex, Date birthday) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.birthday = birthday;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "TbUser [username=" + username + ", password=" + password + ", sex=" + sex + ", birthday=" + birthday
				+ "]";
	}

}

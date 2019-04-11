package com.atguigu.crud.test.pt;

import java.util.Date;

//作者:lhh 创建时间:2019年3月13日 下午3:00:59 
public class TbUserVO {
	private String username;
	private String password;
	private String sex;
	private Date birthday;
	private String phone;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "TbUserVO [username=" + username + ", password=" + password + ", sex=" + sex + ", birthday=" + birthday
				+ ", phone=" + phone + "]";
	}

}

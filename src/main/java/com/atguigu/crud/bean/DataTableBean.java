package com.atguigu.crud.bean;

import java.util.Date;

//作者:lhh 创建时间:2018年11月29日 下午8:20:54 
public class DataTableBean {
	private Integer id;
	private String clusterName;
	private String docNum;
	private Date date;
	
	public DataTableBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DataTableBean(Integer id, String clusterName, String docNum, Date date) {
		super();
		this.id = id;
		this.clusterName = clusterName;
		this.docNum = docNum;
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClusterName() {
		return clusterName;
	}
	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}
	public String getDocNum() {
		return docNum;
	}
	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "DataTableBean [id=" + id + ", clusterName=" + clusterName + ", docNum=" + docNum + ", date=" + date
				+ "]";
	}
	
	
}

package com.atguigu.common.webservice;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//作者:lhh 创建时间:2019年3月1日 上午11:25:11 
@WebService
@SOAPBinding(style = Style.RPC)
public interface ITestService {
	public String sayHello();
}

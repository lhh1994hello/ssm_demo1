package com.atguigu.common.webservice;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//作者:lhh 创建时间:2019年3月1日 上午11:27:32 
@SOAPBinding(style = Style.RPC)
@WebService(endpointInterface = "com.atguigu.common.webservice.ITestService") // endpointInterface是为了在
public class ITestServiceImpl implements ITestService {

	@Override
	public String sayHello() {
		return "hello:";
	}

}

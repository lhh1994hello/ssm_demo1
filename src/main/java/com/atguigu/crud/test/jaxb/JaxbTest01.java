package com.atguigu.crud.test.jaxb;

import java.io.File;
import java.text.MessageFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import com.atguigu.crud.bean.Customer;

//作者:lhh 创建时间:2019年2月19日 上午11:04:20 
/**
 * 将XML格式的数据转成java实体类对应的字段 JAXB, 全称为 Java Architecture for XML Binding, 使用JAXB
 * 注解可以实现java对象和xml相互转换 下面两个方法:
 * 
 * Marshalling – 转换java对象至xml。 Unmarshalling – 转换xml至java对象。
 * 
 * @author lhh
 *
 */
public class JaxbTest01 {

	@Test
	public void beanToXml01() throws JAXBException {
		Customer customer = new Customer();
		customer.setName("张三");
		customer.setId(101);
		customer.setAge(19);
		customer.setCreateTime(new Date());
		String path = "E:/file{0}_file.xml";
		path = MessageFormat.format(path, new Date().getTime());
		File file = new File(path);
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(customer, file);
		jaxbMarshaller.marshal(customer, System.out);
		// xml转java对象
		xmlToBean(path);

	}

	// xml转java对象
	public void xmlToBean(String path) throws JAXBException {
		File file = new File(path);
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Customer customer = (Customer) jaxbUnmarshaller.unmarshal(file);
		System.out.println("xml转java对象:" + customer);
	}

}

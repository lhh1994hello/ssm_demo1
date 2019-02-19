package com.atguigu.se.network.httpclient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.text.MessageFormat;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//作者:lhh 创建时间:2019年2月19日 上午9:16:19 
@SuppressWarnings("all")
public class HttpClientTest01 {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * ①测试不带参数的get请求
	 * 
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	//@Test
	public void doGet() throws ClientProtocolException, IOException {
		// ①创建一个httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String url = "http://localhost:8088/ssm_demo1/httpclient/doGet";
		// ②创建一个Get对象
		HttpGet get = new HttpGet(url);
		// ③执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		// ④获取相应的状态码
		int statusCode = response.getStatusLine().getStatusCode();
		logger.info("状态码:{}", statusCode);

		HttpEntity entity = response.getEntity();
		String result = EntityUtils.toString(entity, "utf-8");
		logger.info("响应结果:{}", result);
		// ⑤关闭httpclient连接
		response.close();
		httpClient.close();
	}

	/**
	 * ②测试带参数的get请求
	 * 
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	@Test
	public void doGetWithParam() throws URISyntaxException, ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String url = "http://localhost:8088/ssm_demo1/httpclient/doGetWithParam";
		URIBuilder uriBuilder = new URIBuilder(url);
		uriBuilder.addParameter("username", "zhangSan");
		uriBuilder.addParameter("password", "123456");
		HttpGet get = new HttpGet(uriBuilder.build());
		CloseableHttpResponse response = httpclient.execute(get);
		int statusCode = response.getStatusLine().getStatusCode();
		logger.info("状态码:{}", statusCode);
		HttpEntity entity = response.getEntity();
		String result = EntityUtils.toString(entity, "utf-8");
		logger.info("响应结果:" + result);
		response.close();
		httpclient.close();
	}

}

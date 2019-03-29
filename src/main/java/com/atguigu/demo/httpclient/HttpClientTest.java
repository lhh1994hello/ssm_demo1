//创建时间:2018年9月23日,下午8:52:19,作者:lhh
package com.atguigu.demo.httpclient;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

/**
 * HttpClient工具使用
 * 
 * @author lhh
 *
 */
public class HttpClientTest {
	// httpClient模拟get请求
	@Test
	public void doGet() throws Exception {
		// http://localhost:8088/ssm_template_project/httpClientRequestTest
		String url = "http://www.baidu.com";
		// 1.创建一个httpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 2.创建一个Get对象
		HttpGet get = new HttpGet(url);
		// 3.执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		// 4.获取响应的结果
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("响应状态码:" + statusCode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity, "utf-8");
		System.out.println("响应结果:" + string);
		// 5.关闭httpClient
		response.close();
		httpClient.close();
	}

	// 带参数的调用方式
	// @Test
	public void doGetWithParam() throws URISyntaxException, ClientProtocolException, IOException {
		// 1.创建一个httpClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建一个uri对象
		URIBuilder uriBuilder = new URIBuilder("http://localhost:8088/ssm_template_project/httpClientRequestTest");
		uriBuilder.addParameter("fr", "aladdin");
		HttpGet get = new HttpGet(uriBuilder.build());
		// 3.执行请求
		CloseableHttpResponse response = httpClient.execute(get);
		// 4.获取响应的结果
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("响应状态码:" + statusCode);
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity, "utf-8");
		System.out.println("响应结果:" + string);
		// 5.关闭httpClient
		response.close();
		httpClient.close();
	}

	// ***************************************

	// @Test
	public void doPost() throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost("http://localhost:8088/ssm_template_project/httpClientRequestTest");
		CloseableHttpResponse response = httpClient.execute(post);
		response.close();
		httpClient.close();
	}

}

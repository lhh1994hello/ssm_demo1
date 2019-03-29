package com.atguigu.demo.httpclient;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

//作者:lhh 创建时间:2019年3月29日 上午9:42:28 
public class HttpClientDemo2 {
	@Test
	public void postDemo() throws ClientProtocolException, IOException {
		String url = "http://58.240.222.101:8081/call400/api_poll_start.php";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		CloseableHttpResponse response = httpClient.execute(post);
		response.close();
		httpClient.close();
	}
}

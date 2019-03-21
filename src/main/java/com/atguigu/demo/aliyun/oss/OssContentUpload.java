package com.atguigu.demo.aliyun.oss;

import java.io.ByteArrayInputStream;

import com.aliyun.oss.OSSClient;
/**
 * 测试文本内容上传
 * @author lhh
 *
 */
//作者:lhh 创建时间:2019年3月17日 下午7:45:45 
public class OssContentUpload {
	private static String accessKeyId = "LTAIuNgr4nB8DeOi";
	private static String accessKeySecret = "hPzF7xG2wtICiIGTyJjqpOBFtkhVxV";

	public static void main(String[] args) {
		// Endpoint以杭州为例，其它Region请按实际情况填写。
		String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
		// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录
		// https://ram.console.aliyun.com 创建RAM账号。

		String bucketName = "lhh20190318";
		String objectName = "a.txt";

		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

		// 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。
		String content = "Hello OSS";
		ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));

		// 关闭OSSClient。
		ossClient.shutdown();
	}
}

package com.atguigu.demo.aliyun.oss;

import com.aliyun.oss.OSSClient;

//作者:lhh 创建时间:2019年3月17日 下午8:39:59 
public class OssDeleteFile {
	public static void main(String[] args) {
		// Endpoint以杭州为例，其它Region请按实际情况填写。
		String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
		// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录
		// https://ram.console.aliyun.com 创建RAM账号。
		String accessKeyId = "LTAIuNgr4nB8DeOi";
		String accessKeySecret = "hPzF7xG2wtICiIGTyJjqpOBFtkhVxV";
		String bucketName = "lhh20190318";
		String objectName = "data/1552826661020.jpg";

		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

		// 删除文件。
		ossClient.deleteObject(bucketName, objectName);

		// 关闭OSSClient。
		ossClient.shutdown();
	}
}

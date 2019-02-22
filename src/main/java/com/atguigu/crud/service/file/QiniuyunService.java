package com.atguigu.crud.service.file;

import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

//作者:lhh 创建时间:2019年1月15日 下午12:45:30 
@Service
public class QiniuyunService {
	private static final Logger logger = LoggerFactory.getLogger(QiniuyunService.class);
	// 域名
	@Value("${qiniuyun.domain.name}")
	private String qiniuyunDomainName;
	// 连接参数
	@Value("${qiniuyun.accesskey}")
	private String qiniuyunAccesskey;
	// 秘钥
	@Value("${qiniuyun.secretkey}")
	private String qiniuyunSecretkey;
	// 要上传的空间
	@Value("${qinuiyun.bucketname}")
	private String qiniuyunBucketname;

	// 图片允许的后缀扩展名
	public static String[] IMAGE_FILE_EXTD = new String[] { "png", "bmp", "jpg", "jpeg", "pdf" };
	// 设置好账号的ACCESS_KEY和SECRET_KEY
	String ACCESS_KEY = "A0YXyW8wWSEU9C3vq7-UYWPlVyhGpJ5Y_KBmlI3V";
	String SECRET_KEY = "zzFqh-pV2yhwJKusFawv2B6KtWgcdTvhrf6h8xKx";
	// 要上传的空间
	String bucketname = "lhh888";

	// 密钥配置
	Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	// 构造一个带指定Zone对象的配置类,不同的七云牛存储区域调用不同的zone
	Configuration cfg = new Configuration(Zone.zone0());
	// ...其他参数参考类注释
	UploadManager uploadManager = new UploadManager(cfg);
	// 测试域名，只有30天有效期
	private static String QINIU_IMAGE_DOMAIN = "http://lhh1994.xyz/";

	// 简单上传，使用默认策略，只需要设置上传的空间名就可以了
	public String getUpToken() {
		return auth.uploadToken(bucketname);
	}

	public String saveImage(MultipartFile file) throws IOException {
		logger.info("域名:{},上传空间:{},ACCESS_KEY:{},SECRET_KEY:{}", qiniuyunDomainName, qiniuyunBucketname,
				qiniuyunAccesskey, qiniuyunSecretkey);
		try {
			int dotPos = file.getOriginalFilename().lastIndexOf(".");
			if (dotPos < 0) {
				return null;
			}
			String fileExt = file.getOriginalFilename().substring(dotPos + 1).toLowerCase();
			// 判断是否是合法的文件后缀
			if (!isFileAllowed(fileExt)) {
				return null;
			}

			String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + fileExt;
			// 调用put方法上传
			Response res = uploadManager.put(file.getBytes(), fileName, getUpToken());
			// 打印返回的信息
			if (res.isOK() && res.isJson()) {
				// 返回这张存储照片的地址
				return QINIU_IMAGE_DOMAIN + JSONObject.parseObject(res.bodyString()).get("key");
			} else {
				logger.error("七牛异常:" + res.bodyString());
				return null;
			}
		} catch (QiniuException e) {
			// 请求失败时打印的异常的信息
			logger.error("七牛异常:" + e.getMessage());
			return null;
		}
	}

	// 检查文件类型
	private boolean isFileAllowed(String fileName) {
		for (String ext : IMAGE_FILE_EXTD) {
			if (ext.equals(fileName)) {
				return true;
			}
		}
		return false;
	}

}

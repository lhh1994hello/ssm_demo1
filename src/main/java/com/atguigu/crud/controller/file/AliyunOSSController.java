package com.atguigu.crud.controller.file;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.crud.util.Msg;
import com.atguigu.crud.util.OSSClientUtil;
import com.atguigu.crud.util.QiniuyunOSSUtil;

//作者:lhh 创建时间:2019年3月17日 下午8:05:55 
@Controller
@RequestMapping("aliyunoss")
public class AliyunOSSController {

	@RequestMapping("/upload")
	@ResponseBody
	public Msg upload(HttpServletRequest request, MultipartFile file) throws IOException {
		OSSClientUtil ossClient = new OSSClientUtil();
		String name = ossClient.uploadImg2Oss(file);
		String imageUrl = ossClient.getImgUrl(name);
		System.out.println("阿里云路径:" + imageUrl);
		QiniuyunOSSUtil qiniuyunOSSUtil = new QiniuyunOSSUtil();
		String qiniuyunImageUrl = qiniuyunOSSUtil.saveImage(file);
		System.out.println("七牛云路径:" + qiniuyunImageUrl);
		Map<String, String> map = new HashMap<>();
		map.put("imageUrl", imageUrl);
		return Msg.Success().add("imageUrl", imageUrl);

	}
}

package com.atguigu.crud.controller.file;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.crud.service.file.QiniuyunService;
import com.atguigu.crud.util.Msg;

//作者:lhh 创建时间:2019年1月15日 下午12:39:19 
/**
 * 测试7牛云上传图片，
 * 目前选择华东地区的能操作成功，
 * @author lhh
 *
 */
@Controller
@RequestMapping(value = "/qiniuyun")
public class QiniuyunUploadController {
	private static final Logger logger = LoggerFactory.getLogger(QiniuyunUploadController.class);

	@Autowired
	private QiniuyunService qiniuyunService;

	@RequestMapping(value = "/upload")
	@ResponseBody
	public Msg uploadTest(@RequestParam(value = "file", required = false) MultipartFile file) {
		if (file == null || file.isEmpty()) {
			logger.info("file参数为空...");
			return Msg.fail();
		}
		try {
			String fileUrl = qiniuyunService.saveImage(file);
			logger.info("图片地址:" + fileUrl);
			return Msg.Success().add("imageUrl", fileUrl);
		} catch (IOException e) {
			e.printStackTrace();
			return Msg.fail();
		}

	}
}

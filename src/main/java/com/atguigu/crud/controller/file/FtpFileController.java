package com.atguigu.crud.controller.file;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.crud.util.FtpUtil;
import com.atguigu.crud.util.Msg;
import com.atguigu.crud.util.NumberUtils;

//作者:lhh 创建时间:2019年1月11日 下午9:24:58 
/**
 * 测试文件上传和下载
 * 
 * @author lhh
 *
 */
@Controller
@RequestMapping("/ftpfile")
@SuppressWarnings("all")
public class FtpFileController {
	Logger logger = LoggerFactory.getLogger(FtpFileController.class);

	@RequestMapping("/fileUpload")
	@ResponseBody
	public Msg fileUpload(MultipartFile file) throws IOException {
		logger.info("文件上传...");
		if (file == null) {
			System.out.println("file为空!");
			return Msg.fail();
		}
		String filename = file.getOriginalFilename();
		filename = NumberUtils.getImageName() + "_" + filename;
		String remotePath="skhx3.jpg";
		boolean uploadFile = FtpUtil.uploadFile("localhost", 21, "ftp", "123", "/", "/test/", filename, file.getInputStream());
		//boolean downloadFile = FtpUtil.downloadFile("localhost", 21, "ftp", "123", remotePath, "a", "E:/file");
		return Msg.Success();
	}
}

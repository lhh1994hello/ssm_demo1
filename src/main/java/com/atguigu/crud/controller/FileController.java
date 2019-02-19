package com.atguigu.crud.controller;
//作者:lhh 创建时间:2018年12月25日 上午9:01:31 

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/file")
@Controller
@SuppressWarnings("all")
public class FileController {
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void download(@RequestParam(value = "filename", required = false) String filename,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		filename = "a.txt";
		// 模拟文件，myfile.txt为需要下载的文件
		String path = "E:\\file" + "\\" + "a.txt";
		// 获取输入流
		InputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));
		// 转码，免得文件名中文乱码
		filename = URLEncoder.encode(filename, "UTF-8");
		// 设置文件下载头
		response.addHeader("Content-Disposition", "attachment;filename=" + filename);
		// 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
		response.setContentType("multipart/form-data");
		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		int len = 0;
		while ((len = bis.read()) != -1) {
			out.write(len);
			out.flush();
		}
		out.close();
	}

}

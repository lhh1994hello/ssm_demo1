package com.atguigu.se.io.file.test1;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//作者:lhh 创建时间:2019年1月12日 下午10:41:56 
/**
 * 测试文件1
 * 
 * @author lhh
 *
 */
public class FileTest1 {
	static Logger logger = LoggerFactory.getLogger(FileTest1.class);

	public static void main(String[] args) throws IOException {
		logger.info("文件夹不存在sdcsd!");
		File file = new File("E:/file/text.txt");
		System.out.println(file.createNewFile());
		logger.info("文件夹不存在!");
	}

	@Test
	public void fun1() throws IOException {
		File parentFile = new File("E:/file2");
		if (!parentFile.exists()) {
			logger.info("文件夹不存在!");
			System.out.println("文件夹不存在123!");
			parentFile.mkdirs();
		}
		File childFile = new File(parentFile, "abc.txt");
		boolean result = childFile.createNewFile();

		System.out.println("result:" + result);
	}
}

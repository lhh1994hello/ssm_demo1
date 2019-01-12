package com.atguigu.crud.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class NumberUtils {
	
	
	
	//判断图片后缀名
		public static boolean judgeImageSuffix(String fileName){
			if(StringUtils.isBlank(fileName)){
				return false;
			}
			String[] imageSuffixArray=new String[]{"jpg","gif","jpeg","bmp","ico","png","jfif"};
			int dotIndex = fileName.lastIndexOf(".");
			String fileSuffix=fileName.substring(dotIndex+1);
			System.out.println("文件后缀:"+fileSuffix);
			for(int i=0;i<imageSuffixArray.length;i++){
				if(fileSuffix.equalsIgnoreCase(imageSuffixArray[i])){
					return true;
				}
			}
			return false;
		}
	//产生图片名称,时间�?+四个随机�?
	public static  String getImageName(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); 
		int num=(int)(Math.random()*9998)+1;  
		String randomNum = String.format("%04d", num);
		String timestamp = sdf.format(new Date());
		return timestamp+randomNum;
	}
	
	//生成随机�?
	public static String getSmsRandom(){
		StringBuffer sb=new StringBuffer();
		int num=1;
		for(int i=0;i<4;i++){
			num=(int)(Math.random()*9)+1;
			String str=num+"";
			sb.append(str);
		}
		System.out.println(sb);
		return sb.toString();
	}
	//生成随机�?,指定长度
	public static String getSmsRandom(int len){
		StringBuffer sb=new StringBuffer();
		int num=1;
		for(int i=0;i<len;i++){
			num=(int)(Math.random()*9)+1;
			String str=num+"";
			sb.append(str);
		}
		return sb.toString();
	}
}

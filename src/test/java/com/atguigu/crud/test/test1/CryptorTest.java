package com.atguigu.crud.test.test1;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;

//作者:lhh 创建时间:2019年1月17日 下午4:50:48 
/**
 * 测试对数据库密码进行加密， 即配置文件中配置的是密文，在程序中解密后获得原文后，再使用
 * 
 * @author lhh
 *
 */
public class CryptorTest {
	/**
	 * 加密方法
	 * 
	 * @param plainText 需加密文本
	 *           
	 */
	public static void testEncrypt(String plainText) {
		StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
		EnvironmentPBEConfig config = new EnvironmentPBEConfig();

		// 加密的算法，这个算法是默认的
		config.setAlgorithm("PBEWithMD5AndDES");
		// 加密的密钥，自定义
		config.setPassword("CSEbfYkitulv73I2p0mXI50JMXoaxZTKJ7");
		standardPBEStringEncryptor.setConfig(config);
		String encryptedText = standardPBEStringEncryptor.encrypt(plainText);
		System.out.println(encryptedText);
	}

	/**
	 * 解密方法
	 * 
	 * @param encryptedText 需解密文本
	 *            
	 */
	public static void testDecrypt(String encryptedText) {
		StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
		EnvironmentPBEConfig config = new EnvironmentPBEConfig();

		// 解密的算法，需同加密算法相同
		config.setAlgorithm("PBEWithMD5AndDES");
		// 解密的密钥，需同加密密钥相同
		config.setPassword("CSEbfYkitulv73I2p0mXI50JMXoaxZTKJ7");
		standardPBEStringEncryptor.setConfig(config);
		String plainText = standardPBEStringEncryptor.decrypt(encryptedText);
		System.out.println(plainText);
	}

	public static void main(String[] args) {
		testEncrypt("root");
		testDecrypt("TU1NovjRHGyjp7cSc6v0sQ==");
	}
}

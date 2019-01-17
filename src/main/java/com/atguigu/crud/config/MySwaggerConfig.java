package com.atguigu.crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//作者:lhh 创建时间:2019年1月11日 下午2:42:01 
/**
 * swagger配置类
 * @author lhh
 *
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
public class MySwaggerConfig {
	
	@SuppressWarnings("all")
	@Bean
	public Docket myDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		docket.apiInfo(apiInfo());
		// 设置只生成被Api这个注解注解过的Ctrl类中有ApiOperation注解的api接口的文档
		docket.select()
		.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
		.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
		.paths(PathSelectors.any()).build();
		return docket;
	}
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .contact(new Contact("lhh", "http://www.baidu.com", "2048737723@qq.com"))
                .version("1.0")
                .build();
    }
	
//	ApiInfo apiInfo = new ApiInfoBuilder().title("MySwagger[Api接口文档]") // 标题.description("描述一下") // 描述
//			.contact(new Contact("lhh", "http://www.baidu.com", "2048737723@qq.com")) // 联系方式
//			.version("1.0").build(); // 版本号		
//	//docket.apiInfo(apiInfo);
	
}

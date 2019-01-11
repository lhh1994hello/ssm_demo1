package com.atguigu.crud.controller.swagger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.crud.util.Msg;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

//作者:lhh 创建时间:2019年1月11日 下午2:46:38 
@RestController
@RequestMapping("/company")
@Api(tags = "company", description = "公司名单")
public class SwaggerController {

	@ResponseBody
	@RequestMapping(value = "/name_get", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ApiOperation(value = "公司列表GET")
	@ApiImplicitParam(paramType = "query", name = "id", value = "公司ID", required = true, dataType = "int")
	public Msg getCompanyGET(@RequestParam(value = "id") Integer id) {
		return Msg.Success();
	}

	@ResponseBody
	@RequestMapping(value = "/name_post", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ApiOperation(value = "公司列表POST")
	@ApiImplicitParam(paramType = "query", name = "id", value = "公司ID", required = true, dataType = "int")
	public Msg getCompanyPost(@RequestParam(value = "id") Integer id) {
		return Msg.Success();
	}

}

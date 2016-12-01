package com.sawyer.framework.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.sawyer.framework.domain.Demo;
import com.sawyer.framework.service.DemoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("/api/test")
public class TestController
{

	@Autowired
	private DemoService demoService;

	@ResponseBody
	@RequestMapping(value = "/show", method = RequestMethod.POST) // 这里指定RequestMethod，如果不指定Swagger会把所有RequestMethod都输出，在实际应用中，具体指定请求类型也使接口更为严谨。
	@ApiOperation(value = "测试接口====", notes = "====测试接口详细描述=====")
	public String show(
			@ApiParam(required = true, name = "name", value = "姓名") @RequestParam(name = "name") String stuName,
			@ApiParam(required = false, name = "content", value = "内容") @RequestParam(name = "content") String content)
	{
		return "success";
	}

	@ResponseBody
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ApiOperation(value = "test get", notes = "test get")
	public List<Demo> get(
			@ApiParam(required = false, name = "name", value = "姓名") 
			@RequestParam(name = "name") String name,
			@RequestHeader ("host") String hostName)
	{
		PageHelper.startPage(1,1);
		return demoService.joinTest(name);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	@ApiOperation(value = "test validate", notes = "test validate")
	public String validate(@RequestBody @Valid Demo demo)
	{
		return "OK";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/get2", method = RequestMethod.GET)
	public String get(
			)
	{
		System.out.println("==============");
		return "OK";
	}

}
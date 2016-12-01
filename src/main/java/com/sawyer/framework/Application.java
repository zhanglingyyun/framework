package com.sawyer.framework;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

import com.sawyer.framework.core.SpringContextUtil;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.sawyer.framework.mapper")
public class Application
{

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args)
	{
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		SpringContextUtil.setApplicationContext(ctx);
		logger.info("spring boot server start ");
	}

}
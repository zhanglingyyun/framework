package com.sawyer.framework.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class SpringContextUtil
{

	private static ApplicationContext applicationContext; // Spring应用上下文环境

	public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		SpringContextUtil.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext()
	{
		return applicationContext;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) throws BeansException
	{
		return (T) applicationContext.getBean(name);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<?> clz) throws BeansException
	{
		return (T) applicationContext.getBean(clz);
	}
}

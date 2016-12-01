package com.sawyer.framework.core.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.pagehelper.StringUtil;

@Aspect
@Component
@Order(-5)
public class WebLogAspect
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ThreadLocal<Long> startTime = new ThreadLocal<Long>();
	
	/**
	 * 定义一个切入点. 解释下：
	 *
	 * ~ 第一个 * 代表任意修饰符及任意返回值. ~ 第二个 * 任意包名 ~ 第三个 * 代表任意方法. ~ 第四个 * 定义在controller包或者子包 ~ 第五个 * 任意方法 ~
	 * .. 匹配任意数量的参数.
	 */
	@Pointcut("execution(public * com.sawyer.*.controller..*.*(..))")
	public void webLog()
	{
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Exception
	{
		startTime.set(System.currentTimeMillis());
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		logger.info(">	url : " + request.getRequestURL().toString());
		logger.info(">	method : " + request.getMethod());
		logger.info(">	ip : " + request.getRemoteAddr());
		// logger.info("> CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
		// + joinPoint.getSignature().getName());
		// logger.info("parameter : " + Arrays.toString(joinPoint.getArgs()));

		Enumeration<?> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements())
		{
			String key = (String) headerNames.nextElement();
			logger.debug(">	" + key + " : " + request.getHeader(key));
		}

		// 获取所有参数：
		Enumeration<String> enu = request.getParameterNames();
		StringBuffer parameters = new StringBuffer();
		while (enu.hasMoreElements())
		{
			String paraName = (String) enu.nextElement();
			parameters.append(paraName).append("=").append(request.getParameter(paraName)).append("&");
		}

		logger.debug(">	parameters : {{}} ", StringUtil.isEmpty(parameters.toString()) ? ""
				: parameters.toString().substring(0, parameters.toString().length() - 1));
		throw new Exception();
	}


	@AfterReturning("webLog()")
	public void doAfterReturning(JoinPoint joinPoint)
	{
		 logger.info("> 耗时（毫秒） : " + (System.currentTimeMillis() - startTime.get()));
	}

}
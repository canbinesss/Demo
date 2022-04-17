package com.example.aspect;


import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.AfterReturning;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.exception.LoginException;
import com.example.utils.Constant;

/**
 * Web Controller层日志AOP
 * 
 * @author canbinesss
 * @since 2018-14-17
 */
@Aspect
@Order(5)
@Component
public class WebLogAspect {

	private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

	ThreadLocal<Long> startTime = new ThreadLocal<Long>();

	@Pointcut("execution(public * com.example.controller..*.*(..))")
	public void webLog() {
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		startTime.set(System.currentTimeMillis());

		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		logger.info("URL : " + request.getRequestURL().toString());
		logger.info("HTTP_METHOD : " + request.getMethod());
		logger.info("IP : " + request.getRemoteAddr());
		logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

		/* */
		logger.info("UserName : " + request.getSession().getAttribute("userName"));
		logger.info("accountName : " + request.getSession().getAttribute("accountName"));
		/**/
		if (validate(request.getRequestURL().toString())) {
			if (request.getSession().getAttribute("userName") == null && request.getSession().getAttribute("accountName") == null) {
				logger.info("没有登录记录,返回登录页面！");
				throw new LoginException();
			}
		}
		
	}
	
	/**
	 * 验证url是否可访问
	 * @param url
	 * @return
	 */
	private boolean validate(String url){
		boolean ret = true;
//		System.err.println(url.indexOf("files"));
//		if(url.indexOf("files") == -1){
			for(String u : Constant.EXCEPT_URL){
				if(url.contains(u)){
					ret = false;
					break;
				}
			}
//		}
		return ret;
	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		logger.info("RESPONSE : " + ret);
		logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
	}
}

package com.example.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


/**
 * 登录异常handler
 * 当出现未登录用户访问系统请求时，自动跳转到登录页面
 * @author canbinesss
 * @since 2019-04-28
 */
@ControllerAdvice
public class LoginExceptionHandler {

	@ExceptionHandler(value = LoginException.class)
	public ModelAndView handlerAuthorizeException() {
		return new ModelAndView("redirect:/login");
	}
}

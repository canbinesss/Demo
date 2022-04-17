package com.example.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/test")
@EnableAutoConfiguration
public class HelloWorld {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@ApiOperation(value = "测试hello", notes = "用于测试controller是否好用")
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public void helloworld(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String msg = "hello 741!";
		redisTemplate.opsForValue().set("kkk", "456123");
		System.out.println(redisTemplate.opsForValue().get("kkk"));
		pw.print(msg);
		pw.flush();
		pw.close();
	}
}


package com.example.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * Druid监控配置
 * @author canbinesss
 * @since 2018-12-13 11:27
 * @since 1.0
 */
@Configuration
public class DruidMoniterConfig {
	
	/**
	 * 配置一个管理后台的Servlet
	 * @return
	 */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        initParams.put("allow","");//IP白名单 (没有配置或者为空，则允许所有访问) 
        initParams.put("deny","");//IP黑名单 (存在共同时，deny优先于allow) 
        initParams.put("resetEnable","false");//禁用HTML页面上的“Reset All”功能  
        
        bean.setInitParameters(initParams);
        return bean;
    }
 
    /**
     * 配置一个web监控的filter
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
 
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
 
        bean.setInitParameters(initParams);
 
        bean.setUrlPatterns(Arrays.asList("/*"));
 
        return  bean;
    }
}

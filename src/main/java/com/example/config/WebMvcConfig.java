package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * 描述:
 * 作者： canbinesss
 * 日期： 2020/5/8 13:28
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/page/end/**")
                .excludePathPatterns("/page/end/login.html",
                        "/page/end/register.html",
                        "/page/end/coachinfo.html",
                        "/page/end/orderforuser.html",
                        "/page/end/loginforuser.html",
                        "/page/end/videolist.html",
                        "/page/end/video.html",
                        "/page/end/goodslist.html",
                        "/page/end/coachlist.html",
                        "/page/end/mine.html",
                        "/page/end/model.html",
                        "/page/end/videolistforuser.html",
                        "/page/end/coachlistforuser.html",
                        "/page/end/record.html",
                        "/page/end/vipmoney.html",
                        "/page/end/ind.html");
    }

    /**
     * 静态资源处理
     **/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        File file = new File("/springboot/");
        if (!file.exists()) {
            file.mkdirs();
        }
        registry.addResourceHandler("/springboot/**").addResourceLocations("file:/springboot/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}

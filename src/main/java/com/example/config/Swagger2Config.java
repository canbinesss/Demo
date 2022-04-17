package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 Config
 * RESTful API文档,还可以测试，很强大
 * @author canbinesss
 * @since 2018-12-12 14:26
 * @version 1.0
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
	// http://localhost:8080/swagger-ui.html
	// Swagger2默认将所有的Controller中的RequestMapping方法都会暴露，
	// 然而在实际开发中，我们并不一定需要把所有API都提现在文档中查看，这种情况下，使用注解
	// @ApiIgnore来解决，如果应用在Controller范围上，则当前Controller中的所有方法都会被忽略，
	// 如果应用在方法上，则对应用的方法忽略暴露API

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.controller")).paths(PathSelectors.any())
				.build();
	}

	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("").description(" v1.0")
				.termsOfServiceUrl("http://localhost:8082").contact("example").version("1.0").build();
	}
}

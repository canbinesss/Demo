package com.example.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.druid.pool.DruidDataSource;

/**
 * Druid数据源配置
 * @author canbinesss
 * create on 2017-04-14
 */
@Configuration
public class DruidDataSourceConfig {
	
	@Bean  	
    @ConfigurationProperties(prefix = "spring.datasource")  
    public DataSource druidDataSource() {  
        DruidDataSource druidDataSource = new DruidDataSource(); 
        return druidDataSource;  
    }
}

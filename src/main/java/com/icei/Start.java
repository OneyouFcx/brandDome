package com.icei;


import org.apache.ibatis.io.VFS;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.util.Properties;


@ComponentScan(basePackages = { "com.icei.*","alicom.api.*","config","alipay.*"})
@EntityScan(basePackages = "com.icei.domain")
@MapperScan(basePackages={"com.icei.mapper","com.icei.mapping"})
@SpringBootApplication
public class Start {
//	//配置mybatis的分页插件pageHelper
//	@Bean
//	public PageHelper pageHelper() {
//		PageHelper pageHelper = new PageHelper();
//		Properties properties = new Properties();
//		properties.setProperty("offsetAsPageNum", "true");
//		properties.setProperty("rowBoundsWithCount", "true");
//		properties.setProperty("reasonable", "true");
//		properties.setProperty("dialect", "mysql"); // 配置mysql数据库的方言
//		pageHelper.setProperties(properties);
//		return pageHelper;
//	}
	public static void main(String[] args) {
		SpringApplication.run(Start.class,args);
	}
}
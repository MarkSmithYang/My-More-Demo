package com.ddb.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTransactionManagement
public class ApplicationBegin extends WebSecurityConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(ApplicationBegin.class, args);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().disable();//取消每次启动服务访问时的校验
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}

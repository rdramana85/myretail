package com.target.myretail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.AsyncRestTemplate;

@Configuration
public class MyRetailConfiguration {
	
	@Bean
	public AsyncRestTemplate getAsyncRestTemplate(){
		return new AsyncRestTemplate();
	}
	
}

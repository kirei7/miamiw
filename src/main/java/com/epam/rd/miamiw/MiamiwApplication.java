package com.epam.rd.miamiw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilderFactory;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MiamiwApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiamiwApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public UriBuilderFactory uriBuilderFactory() {
		return new DefaultUriBuilderFactory();
	}
}

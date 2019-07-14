package com.imaginology.resultservice.swagger;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import javax.servlet.Filter;


@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter{
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
		@Bean
		public Docket Api(){
			return new Docket(DocumentationType.SWAGGER_2)
					.select()	
	                .apis(RequestHandlerSelectors.basePackage("com.imaginology.resultservice.controller"))
			         .paths(PathSelectors.any()).build();
			         
		}
		
		@Profile({ "prod", "staging" })
		@Bean
		public FilterRegistrationBean urlFilter() {
			return new FilterRegistrationBean(new SwaggerUrlFilter());
		}
	}
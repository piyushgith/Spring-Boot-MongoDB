package com.mongodb.example.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {
	
	@Bean
	public Docket api() {
		List<Parameter> aParameters = new ArrayList<Parameter>();
		// Adding Header , make true to mandatory headers
		//aParameters.add(new ParameterBuilder().name("JWT Token").modelRef(new ModelRef("string")).parameterType("header").required(false).defaultValue("Bearer jwt").build());
		aParameters.add(new ParameterBuilder().name("ApiKey").modelRef(new ModelRef("string")).parameterType("header").required(false).defaultValue("API Key").build());
		aParameters.add(new ParameterBuilder().name("header1").modelRef(new ModelRef("string")).parameterType("header").required(true).defaultValue("API Key").build());
		aParameters.add(new ParameterBuilder().name("header2").modelRef(new ModelRef("string")).parameterType("header").required(false).defaultValue("").build());

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.mongodb.example")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo()).globalOperationParameters(aParameters);
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Service Name", "API Description", "API", "Terms of service",
				new Contact("name", "webaddress", "email"), "License of API", "API license URL",
				Collections.emptyList());
	}

	//normal way
	public Docket api_1() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.mongodb.example")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo());
	}
	
	//not needed generally
	
	/*
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/api/swagger-ui.html**")
				.addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
		registry.addResourceHandler("/api/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}*/
}

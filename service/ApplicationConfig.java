package com.ty.springboot_hospital_project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {

	public Docket getName() {
		Contact contact = new Contact("TY", "www.ty.com", "tysupport@gmail.com");

		List<VendorExtension> extensions = new ArrayList<>();

		ApiInfo apiInfo = new ApiInfo("hospital app", "Hospital app version 1.0", "version 1.0", "www.tyterms.com",
				contact, "asdf12qwerty", "www.tylic.com", extensions);

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ty.springboot_hospital_project")).build()
				.apiInfo(apiInfo).useDefaultResponseMessages(false);
	}
}

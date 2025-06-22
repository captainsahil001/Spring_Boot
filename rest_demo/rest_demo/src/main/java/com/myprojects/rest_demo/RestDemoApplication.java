package com.myprojects.rest_demo;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class RestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
	}

	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cloud Vendor Application")
                        .description("Cloud Vendor Documentation")
                        .version("1.0")
                        .termsOfService("Cloud Vendor Service Terms")
                        .contact(new Contact()
                                .name("Sahil Ghosh")
                                .url("https://captainsahil001.github.io/sahilghosh.github.io/")
                                .email("sahilghosh0512@gmail.com"))
                        .license(new License()
                                .name("Sahil Projects License")
                                .url("https://captainsahil001.github.io/sahilghosh.github.io/"))
                );
    }

    // 👇 This filters the controllers by path and package (like your .paths + .apis)
    @Bean
    public GroupedOpenApi cloudVendorApi() {
        return GroupedOpenApi.builder()
                .group("cloudvendor") // logical name for Swagger grouping
                .pathsToMatch("/cloudvendor/**") // endpoint filtering
                .packagesToScan("com.myprojects.rest_demo") // controller package
                .build();
    }

}
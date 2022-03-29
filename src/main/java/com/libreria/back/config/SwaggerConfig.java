package com.libreria.back.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/partituras/**"))
                .apis(RequestHandlerSelectors.basePackage("com.libreria.back"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Libreria back",
                "Api para llevar control de libros y partituras",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Omar Prieto", "no web", "omarprietomendez@gmail.com"),
                "Api License",
                "no web",
                Collections.emptyList());

    }
}

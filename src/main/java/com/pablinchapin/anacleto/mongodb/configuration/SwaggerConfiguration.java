/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pablinchapin.anacleto.mongodb.configuration;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author pvargas
 */

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
    
    
    @Bean
    public Docket userApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(usersApiInfo())
                .select()
                .paths(userPaths())
                .apis(RequestHandlerSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo usersApiInfo() {
        return new ApiInfoBuilder()
                .title("Service User")
                .version("1.0")
                .license("Apache Licence Version 2.0")
                .build();
    }

    private Predicate<String> userPaths() {
        return regex("/user.*");
    }
    
}

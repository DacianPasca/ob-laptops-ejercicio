package com.obspring.obh2jpawebdevtools.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * HTML: http://localhost:8080/swagger-ui/
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiDetails(){

        return new ApiInfo("Laptop API REST",
                "Library Api rest docs for laptops database",
                "0.1",
                "http://www.youtube.com",
                new Contact("Dacian","http://www.youtube.com","dacian@example.com"),
                "Fair Use",
                "http://www.youtube.com",
                Collections.emptyList());
    }
}

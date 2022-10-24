package com.rifqimuhammadaziz.springtemplate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfiguration {

    // ACCESS : url:port/swagger-ui/index.html

    public static final String AUTHORIZATION_HEADER = "Authorization";

    private ApiKey apiKey() {
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Spring REST API Template",
                "Spring REST API Template Description",
                "1",
                "Term of service",
                new Contact("Rifqi Muhammad", "https://github.com/rifqimuhammadaziz", "example@gmail.com"),
                "License of API",
                "API License URL",
                Collections.emptyList()
        );
        // OR
//        return new ApiInfoBuilder()
//                .title("API Title")
//                .description("APi Description")
//                .version("1.0.0")
//                .license("Apache 2.0")
//                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
//                .contact(new Contact("Author Name", "Links", "mail@example.com"))
//                .build();
    }

    @Bean
    public Docket api() {
        // with security
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .securityContexts(Arrays.asList(securityContext()))
//                .securitySchemes(Arrays.asList(apiKey()))
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rifqimuhammadaziz.springtemplate"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext
//                .builder()
//                .securityReferences(defaultAuth())
//                .build();
//    }
//
//    private List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//
//        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
//    }
}

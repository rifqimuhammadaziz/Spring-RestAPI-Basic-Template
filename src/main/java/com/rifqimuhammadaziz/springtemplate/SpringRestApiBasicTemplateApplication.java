package com.rifqimuhammadaziz.springtemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableCaching
@ComponentScan(basePackages = "com.*")
public class SpringRestApiBasicTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApiBasicTemplateApplication.class, args);
    }

}

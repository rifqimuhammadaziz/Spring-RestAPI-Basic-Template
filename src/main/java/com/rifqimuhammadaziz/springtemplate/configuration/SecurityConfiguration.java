package com.rifqimuhammadaziz.springtemplate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests((authorize) -> authorize
                        .antMatchers(HttpMethod.GET, "/api/v1/**").permitAll() // controller
                        .antMatchers(HttpMethod.POST, "/api/v1/**").permitAll()
                        .antMatchers("/v2/api-docs/**").permitAll() // swagger
                        .antMatchers("/swagger-ui/**").permitAll() // swagger
                        .antMatchers("/swagger-resources/**").permitAll() // swagger
                        .antMatchers("/swagger-ui.html").permitAll() // swagger
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}

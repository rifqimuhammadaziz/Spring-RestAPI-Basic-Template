package com.rifqimuhammadaziz.springtemplate.controller;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@Api(value = "Hello Controller")
public class HelloController {

    @GetMapping
    @Operation(description = "This is a hello REST API")
    public String hello() {
        return "Hello World!";
    }
}

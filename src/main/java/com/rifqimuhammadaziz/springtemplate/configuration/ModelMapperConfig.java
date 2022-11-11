package com.rifqimuhammadaziz.springtemplate.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

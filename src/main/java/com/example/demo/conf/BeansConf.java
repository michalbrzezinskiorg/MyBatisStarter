package com.example.demo.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConf {
    @Bean
    public ObjectMapper getOM() {
        return new ObjectMapper();
    }
}

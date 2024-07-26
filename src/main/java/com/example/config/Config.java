package com.example.config;

import org.example.regulator.Regulator;
import org.example.regulator.RegulatorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Regulator regulator() {
        return RegulatorImpl.getInstance();
    }
}

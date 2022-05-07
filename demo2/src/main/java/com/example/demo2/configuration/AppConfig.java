package com.example.demo2.configuration;

import com.example.demo2.Calculator;
import com.example.demo2.bean.AddCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    Calculator bean1(){
        return new AddCalculator();
    }
}

package com.example.demo2.runner;

import com.example.demo2.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SeparateRunner implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(SeparateRunner.class.getName());

    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("execute somethings");
        LOGGER.info("execute more things");
        Calculator cal1 = context.getBean("add", Calculator.class);
        LOGGER.info("1. result={}",cal1.calc(3,4));
        Calculator cal2 = context.getBean("sub",Calculator.class);
        LOGGER.info("2. result={}",cal2.calc(3,4));
        Calculator cal3 = context.getBean("mul",Calculator.class);
        LOGGER.info("3. result={}",cal3.calc(3,4));
    }
}

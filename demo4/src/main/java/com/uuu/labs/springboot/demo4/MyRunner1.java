package com.uuu.labs.springboot.demo4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyRunner1 implements CommandLineRunner {
    @Autowired
    NamedParameterJdbcTemplate template;
    @Override
    public void run(String... args) throws Exception {
      log.info("got a jdbc template:{}",template.getJdbcTemplate().getDataSource().toString());
    }
}

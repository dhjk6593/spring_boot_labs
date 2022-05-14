package com.example.demo5;

import com.example.demo5.beans.Beverage;
import com.example.demo5.repositories.MyCRUDRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Runner1 implements CommandLineRunner {

    public Runner1(MyCRUDRepository repository) {
         this.repository = repository;
    }

    MyCRUDRepository repository;

    @Override
    public void run(String... args) throws Exception {
        initDatabase();
    }

    private void initDatabase() {
        repository.save(new Beverage("Black Tea","with Milk"));
    }

}

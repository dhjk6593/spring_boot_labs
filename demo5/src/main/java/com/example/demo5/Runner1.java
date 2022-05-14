package com.example.demo5;

import com.example.demo5.beans.Beverage;
import com.example.demo5.repositories.MyCRUDRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class Runner1 implements CommandLineRunner {

    public Runner1(MyCRUDRepository repository) {
         this.repository = repository;
    }

    MyCRUDRepository repository;

    @Override
    public void run(String... args) throws Exception {
        initDatabase();
        dumpAllDatabase();
        getOne();
        getSome();
        getByTitle();
        getByDetail();
    }

    private void initDatabase() {
        repository.save(new Beverage("Black Tea","with Milk"));
        repository.save(new Beverage("Black Coffee", "with Milk"));
        repository.save(new Beverage("Black Coffee", "no Milk"));
        repository.save(new Beverage("Ice Coffee", "with Milk"));
        repository.save(new Beverage("Ice Coffee", "no Milk"));
        repository.save(new Beverage("Hot Latte", "with Milk"));
        repository.save(new Beverage("Ice Latte", "with Milk"));
        repository.save(new Beverage("Hot Americano", "no Milk"));
        repository.save(new Beverage("Ice Americano", "no Milk"));
        repository.save(new Beverage("Hot Espresso", "super strong"));
        repository.save(new Beverage("Ice Espresso", "super strong"));
    }

    private void dumpAllDatabase() {
        repository.findAll()
                  .forEach(this::printBeverage);
    }

    private void getOne() {
        Optional<Beverage> opt = repository.findById(1L);
        Beverage b = opt.get();
        b.setTitle("Green Tea");
        repository.save(b);
        dumpAllDatabase();
    }

    private void getSome() {
        log.info("##### getSome #####");
        PageRequest firstReq = PageRequest.of(0,3);
        repository.findAll(firstReq)
                  .forEach(this::printBeverage);

        log.info("##### next Page #####");
        repository.findAll(firstReq.next())
                  .forEach(this::printBeverage);
    }

    private void getByTitle() {
        log.info("##### get By title #####");
        repository.findMatchByTitle("Ice Coffee")
                  .forEach(this::printBeverage);
    }

    private void getByDetail() {
        log.info("##### get by detail #####");
        repository.findByDetailIgnoreCase("with milk")
                  .forEach(this::printBeverage);
    }

    private void printBeverage(Beverage b) {
        log.info("{}", b);
    }
}

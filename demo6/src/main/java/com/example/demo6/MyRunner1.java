package com.example.demo6;

import com.example.demo6.bean.Customer;
import com.example.demo6.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyRunner1 implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    @Override
    public void run(String... args) throws Exception {
        initSampleData();
        findAll();
    }

    private void initSampleData() {
        Customer c1 = repository.save(new Customer("Mark", "Ho"));
        printCustomer(c1);
        repository.save(new Customer("Ella", "Chang"));
        repository.save(new Customer("Louis", "Chen"));
        repository.save(new Customer("John", "Ho"));
        repository.save(new Customer("Abby", "Lin"));
        repository.save(new Customer("Robert", "Lin"));
        repository.save(new Customer("Andy", "Lee"));
        repository.save(new Customer("Jackson", "Hsiao"));
        repository.findAll().forEach(this::printCustomer);
    }

    private void findAll() {
        log.info("##### findAll #####");
        repository.findAllOrderByName()
                  .forEach(this::printCustomer);
    }

    private void printCustomer(Customer c) {
        log.info("{}", c);
    }

}

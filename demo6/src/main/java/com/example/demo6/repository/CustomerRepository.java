package com.example.demo6.repository;


import com.example.demo6.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT x FROM Customer x ORDER BY x.lastName, x.firstName")
    List<Customer> findAllOrderByName();

}

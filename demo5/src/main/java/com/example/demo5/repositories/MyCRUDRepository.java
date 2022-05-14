package com.example.demo5.repositories;

import com.example.demo5.beans.Beverage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MyCRUDRepository extends CrudRepository<Beverage, Long> {
    Page<Beverage> findAll(Pageable page);
    List<Beverage> findMatchByTitle(String title);
    List<Beverage> findByDetailIgnoreCase(String detail);
}

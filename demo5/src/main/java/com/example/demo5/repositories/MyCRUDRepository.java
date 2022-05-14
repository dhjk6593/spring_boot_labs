package com.example.demo5.repositories;

import com.example.demo5.beans.Beverage;
import org.springframework.data.repository.CrudRepository;

public interface MyCRUDRepository extends CrudRepository<Beverage, Long> {
}

package com.lambdaschool.javaorders.repositories;

import com.lambdaschool.javaorders.models.Customers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomersRepo extends CrudRepository<Customers, Long> {

    List<Customers> findByNameContainingIgnoreCase(String subname);

}
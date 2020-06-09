package com.lambdaschool.javaorders.repositories;

import com.lambdaschool.javaorders.models.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepo extends CrudRepository<Orders, Long> {

    List<Orders> findByOrderByAdvancementamountGreaterThan(long num);

}
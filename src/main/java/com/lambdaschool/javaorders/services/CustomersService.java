package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Agents;
import com.lambdaschool.javaorders.models.Customers;
import com.lambdaschool.javaorders.models.Orders;

import java.util.List;

public interface CustomersService {

    List<Customers> findAllCustomers();

    Customers findCustomerById(long id);

    List<Customers> findByNameLike(String thename);

    Agents findAgentById(long id);

    Orders findOrderById(long id);

//    List<Orders> findOrdersWithAdvanceAmount();

}

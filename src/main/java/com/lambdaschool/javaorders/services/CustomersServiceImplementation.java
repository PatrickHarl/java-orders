package com.lambdaschool.javaorders.services;


import com.lambdaschool.javaorders.models.Agents;
import com.lambdaschool.javaorders.models.Customers;
import com.lambdaschool.javaorders.models.Orders;
import com.lambdaschool.javaorders.repositories.AgentsRepo;
import com.lambdaschool.javaorders.repositories.CustomersRepo;
import com.lambdaschool.javaorders.repositories.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "customersService")
public class CustomersServiceImplementation implements CustomersService{

    @Autowired
    private CustomersRepo custrepos;
    @Autowired
    private AgentsRepo agentrepos;
    @Autowired
    private OrdersRepo orderrepos;

    @Override
    public List<Customers> findAllCustomers() {

        List<Customers> cstList = new ArrayList<>();

        custrepos.findAll().iterator().forEachRemaining(cstList::add);

        return cstList;
    }

    @Override
    public Customers findCustomerById(long id) {
        return custrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer " + id + " Not Found"));
    }

    @Override
    public List<Customers> findByNameLike(String thename) {
        return custrepos.findByCustnameContainingIgnoringCase(thename);
    }

    @Override
    public Agents findAgentById(long id) {
        return agentrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Agent " + id + " Not Found"));
    }

    @Override
    public Orders findOrderById(long id) {
        return orderrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Order " + id + " Not Found"));
    }

//    @Override
//    public List<Orders> findOrdersWithAdvanceAmount() {
//        return orderrepos.findByOrderByAdvancementamountGreaterThan(0);
//    }
}

package com.lucianna.mendonca.onlineorderformwebapp.controller;

import com.lucianna.mendonca.onlineorderformwebapp.model.Customer;
import com.lucianna.mendonca.onlineorderformwebapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@ModelAttribute Customer customer){
        // save customer
        Customer savedCustomer = customerRepository.save(customer);
        // return the saved customer
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customer>> getCustomerById (@PathVariable Long id){
        // find customer by id
        Optional<Customer> customer = customerRepository.findById(id);
        // return found customer
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}

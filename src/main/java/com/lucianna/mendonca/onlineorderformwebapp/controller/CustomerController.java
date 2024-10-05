package com.lucianna.mendonca.onlineorderformwebapp.controller;

import com.lucianna.mendonca.onlineorderformwebapp.model.CustomerModel;
import com.lucianna.mendonca.onlineorderformwebapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/smartphone-web-form")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public ResponseEntity<CustomerModel> saveCustomer(@ModelAttribute CustomerModel customer){
        // save customer
        CustomerModel savedCustomer = customerRepository.save(customer);
        // return the saved customer
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CustomerModel>> getCustomerById (@PathVariable Long id){
        // find customer by id
        Optional<CustomerModel> customer = customerRepository.findById(id);
        // return found customer
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}

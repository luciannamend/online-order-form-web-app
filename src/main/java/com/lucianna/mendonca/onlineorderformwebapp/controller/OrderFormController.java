package com.lucianna.mendonca.onlineorderformwebapp.controller;

import com.lucianna.mendonca.onlineorderformwebapp.model.CustomerModel;
import com.lucianna.mendonca.onlineorderformwebapp.model.OrderModel;
import com.lucianna.mendonca.onlineorderformwebapp.repository.CustomerRepository;
import com.lucianna.mendonca.onlineorderformwebapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/submit-order")
public class OrderFormController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity<String> submitOrder(
            @ModelAttribute CustomerModel customer,
            @ModelAttribute OrderModel order
    ) {
        // Save customer details
        customerRepository.save(customer);

        // Save order details
        orderRepository.save(order);

        // Return a success message or redirect
        return new ResponseEntity<>("Order submitted successfully!", HttpStatus.CREATED);
    }
}

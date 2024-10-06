package com.lucianna.mendonca.onlineorderformwebapp.controller;

import com.lucianna.mendonca.onlineorderformwebapp.model.OrderModel;
import com.lucianna.mendonca.onlineorderformwebapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity<OrderModel> saveOrder(@ModelAttribute OrderModel order){
        // save order
        OrderModel savedOrder = orderRepository.save(order);
        // return saved order
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
}

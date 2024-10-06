package com.lucianna.mendonca.onlineorderformwebapp.controller;

import com.lucianna.mendonca.onlineorderformwebapp.model.Customer;
import com.lucianna.mendonca.onlineorderformwebapp.model.Order;
import com.lucianna.mendonca.onlineorderformwebapp.repository.CustomerRepository;
import com.lucianna.mendonca.onlineorderformwebapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping
public class OrderController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity<Order> saveOrder(@ModelAttribute Order order){
        // save order
        Order savedOrder = orderRepository.save(order);
        // return saved order
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @PostMapping("/submit-order")
    public RedirectView submitOrder(@ModelAttribute Customer customer, @ModelAttribute Order order) {
        // Save customer details
        customerRepository.save(customer);

        Long customerId = customer.getId();

        // Save order details
        orderRepository.save(order);

        // Redirect
        return new RedirectView("show-order");
    }

//    @GetMapping("/show-order")
//    public String getOrder(){
//        List<Order> orders = orderRepository.findAll();
//
//        return "show-order";
//    }

    @GetMapping("/orderConfirmation/{customerId}/{orderId}")
    public String getOrderConfirmation(@PathVariable Long customerId, @PathVariable Long orderId, Model model) {
        // Fetch the customer and order from the database
        Optional<Customer> customer = customerRepository.findById(customerId);
        Optional<Order> order = orderRepository.findById(orderId);

        // Add customer and order data to the model
        if (customer.isPresent() && order.isPresent()) {
            model.addAttribute("customer", customer.get());
            model.addAttribute("order", order.get());
            return ("show-order");
        }
        return ("index");
    }

}

package com.lucianna.mendonca.onlineorderformwebapp.controller;

import com.lucianna.mendonca.onlineorderformwebapp.model.Product;
import com.lucianna.mendonca.onlineorderformwebapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //@GetMapping("/products")

}

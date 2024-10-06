package com.lucianna.mendonca.onlineorderformwebapp;

import com.lucianna.mendonca.onlineorderformwebapp.model.Product;
import com.lucianna.mendonca.onlineorderformwebapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OnlineOrderFormWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineOrderFormWebAppApplication.class, args);
    }
}

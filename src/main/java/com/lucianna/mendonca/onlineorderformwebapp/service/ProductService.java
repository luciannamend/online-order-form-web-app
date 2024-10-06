package com.lucianna.mendonca.onlineorderformwebapp.service;

import com.lucianna.mendonca.onlineorderformwebapp.model.Product;
import com.lucianna.mendonca.onlineorderformwebapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {

        List<Product> products = productRepository.findAll();

        if(!products.isEmpty()){
            return products;
        }
        return productRepository.saveAll(createProductList());
    }

    private List<Product> createProductList(){

        List<Product> productList = new ArrayList<>();

        // Apple Products
        productList.add(new Product(null, 1, "Apple", "iPhone 14", new BigDecimal("799.99")));
        productList.add(new Product(null, 2, "Apple", "iPhone 15", new BigDecimal("899.99")));
        productList.add(new Product(null, 3, "Apple", "iPhone 16", new BigDecimal("999.99")));

        // Samsung Products
        productList.add(new Product(null, 4, "Samsung", "Galaxy S23", new BigDecimal("850.00")));
        productList.add(new Product(null, 5, "Samsung", "Galaxy S22", new BigDecimal("750.00")));
        productList.add(new Product(null, 6, "Samsung", "Galaxy Note 20", new BigDecimal("950.00")));

        // Google Products
        productList.add(new Product(null, 7, "Google", "Pixel 7", new BigDecimal("699.99")));
        productList.add(new Product(null, 8, "Google", "Pixel 6", new BigDecimal("599.99")));

        return  productList;
    }
}

package com.lucianna.mendonca.onlineorderformwebapp.repository;

import com.lucianna.mendonca.onlineorderformwebapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

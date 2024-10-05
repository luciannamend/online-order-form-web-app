package com.lucianna.mendonca.onlineorderformwebapp.repository;

import com.lucianna.mendonca.onlineorderformwebapp.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderModel, Integer> {
}

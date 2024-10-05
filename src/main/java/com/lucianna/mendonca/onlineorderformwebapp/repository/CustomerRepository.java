package com.lucianna.mendonca.onlineorderformwebapp.repository;

import com.lucianna.mendonca.onlineorderformwebapp.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerModel, Integer> {
}

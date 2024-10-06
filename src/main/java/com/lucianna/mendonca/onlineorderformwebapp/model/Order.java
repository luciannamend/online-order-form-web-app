package com.lucianna.mendonca.onlineorderformwebapp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "online_order")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    // foreign key
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // foreign key
    @OneToOne
    @JoinColumn(name="product_id")
    private Product product;

    // Constructors
    public Order() {
    }

    public Order(Long orderId, int quantity, BigDecimal totalAmount, Customer customer, Product product) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.customer = customer;
        this.product = product;
    }

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

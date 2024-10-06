package com.lucianna.mendonca.onlineorderformwebapp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "online_order")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_number")
    private Long productNumber;

    @Column(name = "phone_brand")
    private String phoneBrand;

    @Column(name = "phone_model")
    private String phoneModel;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    // foreign key
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    //Constructors
    public Order(){}

    public Order(Long id, Long productNumber, String phoneBrand, String phoneModel,
                 int quantity, BigDecimal totalAmount, Customer customer) {
        this.id = id;
        this.productNumber = productNumber;
        this.phoneBrand = phoneBrand;
        this.phoneModel = phoneModel;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public String getPhoneBrand() {
        return phoneBrand;
    }

    public void setPhoneBrand(String phoneBrand) {
        this.phoneBrand = phoneBrand;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
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
}

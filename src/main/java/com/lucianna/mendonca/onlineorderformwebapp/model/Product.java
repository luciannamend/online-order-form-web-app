package com.lucianna.mendonca.onlineorderformwebapp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_number")
    private int productNumber;

    @Column(name = "phone_brand")
    private String phoneBrand;

    @Column(name = "phone_model")
    private String phoneModel;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    //Constructors
    public Product() {
    }

    public Product(Long productId, int productNumber, String phoneBrand, String phoneModel, BigDecimal unitPrice) {
        this.productId = productId;
        this.productNumber = productNumber;
        this.phoneBrand = phoneBrand;
        this.phoneModel = phoneModel;
        this.unitPrice = unitPrice;

    }

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}

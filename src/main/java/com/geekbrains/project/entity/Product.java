package com.geekbrains.project.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
public class Product {
    @Id
    private UUID product_id;

    private String title_prod;
    private BigDecimal price;
    private int count;
    @ManyToOne
    @JoinColumn(name = "created_by")
    private Person createdBy;
    private String vendorCode;
    private LocalDateTime createdAt;

    @PrePersist
    public void init() {
        if(this.product_id == null) {
            this.product_id = UUID.randomUUID();
        }

        this.createdAt = LocalDateTime.now();
    }

    public void incrementCount() {
        this.count++;
    }

    public void decreaseCount() {
        this.count--;
    }

    public UUID getId() {
        return product_id;
    }

    public Product setId(UUID product_id) {
        this.product_id = product_id;
        return this;
    }

    public String getName() {
        return title_prod;
    }

    public Product setName(String title_prod) {
        this.title_prod = title_prod;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public int getCount() {
        return count;
    }

    public Product setCount(int count) {
        this.count = count;
        return this;
    }

    public Person getCreatedBy() {
        return createdBy;
    }

    public Product setCreatedBy(Person createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public Product setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Product setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}

package com.geekbrains.project.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    private UUID id;
    @Column(name = "title_prod")
    private String title;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "count")
    private int count;
    @ManyToOne
    @JoinColumn(name = "created")
    private Person person;
    @Column(name = "vendor_code")
    private String vendorCode;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void init() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
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
        return id;
    }

    public Product setId(UUID product_id) {
        this.id = product_id;
        return this;
    }

    public String getName() {
        return title;
    }

    public Product setName(String title) {
        this.title = title;
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
        return person;
    }

    public Product setCreatedBy(Person person) {
        this.person = person;
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

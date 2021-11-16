package com.geekbrains.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {
    @Column(name = "id")
    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

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
        if(id == null){
            id = UUID.randomUUID();
        }
        if(createdAt == null){
            createdAt = LocalDateTime.now();
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Person getUser() {
        return person;
    }

    public void setUser(Person person) {
        this.person = person;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void incrementCount() {
        count++;
    }

    public void decreaseCount() {
        if(count>0){
            count--;
        }

    }
}

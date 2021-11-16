package com.geekbrains.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cart")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Cart {

    @Id
    @Column(name = "cart_id")
    private UUID id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Person person;

    @Type(type = "jsonb")
    @Column(name = "products")
    private List<InnerProduct> products;

    @PrePersist
    void init(){
        if(createdAt == null){
            createdAt = LocalDateTime.now();
        }
        if(id == null){
            id = UUID.randomUUID();
        }
    }
    public static class InnerProduct implements Serializable {
        private UUID id;
        private String name;
        private BigDecimal price;
        private int count;
        private String vendorCode;


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

        public String getVendorCode() {
            return vendorCode;
        }

        public void setVendorCode(String vendorCode) {
            this.vendorCode = vendorCode;
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Person getUser() {
        return person;
    }

    public void setUser(Person person) {
        this.person = person;
    }

    public List<InnerProduct> getProducts() {
        return products;
    }

    public void setProducts(List<InnerProduct> products) {
        this.products = products;
    }
}

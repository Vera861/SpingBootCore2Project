package com.geekbrains.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "cart_id")
    Cart cart;
    @Column(name = "number")
    int number;
    @Column(name = "dilivery_address")
    String deliveryAddress;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @PrePersist
    public void init(){
        if(id == null){
            id = UUID.randomUUID();
        }
        if(createdAt == null){
            createdAt = LocalDateTime.now();
        }
    }
}

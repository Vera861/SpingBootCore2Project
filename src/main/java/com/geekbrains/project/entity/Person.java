package com.geekbrains.project.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "person_id")
    private UUID id;
    @Column(name = "last_name")
     private String lastName;
    @Column(name = "first_name")
     private String firstName;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "phone")
     private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "balance")
    private String balance;
    @Column(name = "role")
    private String role;
    @Column(name = "email")
    private String email;
    @Column(name = "created_at")
     private LocalDateTime createdAt;
     private String password;

    @PrePersist
    public void init() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
        this.createdAt = LocalDateTime.now();
    }

    public UUID getPerson_id() {
        return id;
    }

    public void setPerson_id(UUID person_id) {
        this.id = person_id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
package com.geekbrains.project.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "person")
public class Person {
    @Id
    private UUID person_id;
    @Column(name = "last_name", length = 128, nullable = false)
    private String lastName;
    @Column(name = "first_name", length = 128, nullable = false)
    private String firstName;
    @Column(name = "phone", length = 14, nullable = false)
    private String phone;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "password", length = 128, nullable = false)
    private String password;

    @PrePersist
    public void init() {
        if (this.person_id == null) {
            this.person_id = UUID.randomUUID();
        }

        this.createdAt = LocalDateTime.now();
    }

    public UUID getUser_id() {
        return person_id;
    }

    public Person setUser_id(UUID id) {
        this.person_id = id;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Person setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Person setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Person setPassword(String password) {
        this.password = password;
        return this;
    }
}
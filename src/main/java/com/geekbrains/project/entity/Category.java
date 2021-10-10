package com.geekbrains.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "category")
public class Category {
    @Id
    private UUID category_id;
    @Column(name = "title_cat", length = 128, nullable = false)
    private String title_cat;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public UUID getCategory_id() {
        return category_id;
    }

    public void setCategory_id(UUID category_id) {
        this.category_id = category_id;
    }

    public String getTitle_cat() {
        return title_cat;
    }

    public void setTitle_cat(String title_cat) {
        this.title_cat = title_cat;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

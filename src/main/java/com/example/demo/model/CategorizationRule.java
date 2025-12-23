package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CategorizationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String keyword;
    private String matchType; // EXACT / CONTAINS / REGEX
    private Integer priority;

    private LocalDateTime createdAt;

    
    public CategorizationRule() {}


    public CategorizationRule(Category category, String keyword, String matchType, Integer priority) {
        this.category = category;
        this.keyword = keyword;
        this.matchType = matchType;
        this.priority = priority;
    }

    @PrePersist
    void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    
    public Long getId() { return id; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String getMatchType() { return matchType; }
    public void setMatchType(String matchType) { this.matchType = matchType; }

    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { this.priority = priority; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

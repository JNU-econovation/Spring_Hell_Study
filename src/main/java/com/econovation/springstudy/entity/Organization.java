package com.econovation.springstudy.entity;

import jakarta.persistence.*;

@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String businessName;
    @Column
    private Long budget;

    public String getBusinessName() {
        return businessName;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }
}

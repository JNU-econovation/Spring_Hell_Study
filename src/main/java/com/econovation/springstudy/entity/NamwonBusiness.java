package com.econovation.springstudy.entity;

import jakarta.persistence.*;

@Entity
public class NamwonBusiness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String businessName;
    @Column
    private Long budget;

    public NamwonBusiness() {
    }

    public NamwonBusiness(String businessName, Long budget) {
        this.businessName = businessName;
        this.budget = budget;
    }

    public String getBusinessName() {
        return businessName;
    }


    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }
}

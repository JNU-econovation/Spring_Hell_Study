package com.econovation.springstudy.entity;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

@Entity
public class NamwonPrinterContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Organization organization;
    private int totalBoughtNumber;
    private int boughtNumberForDiscount;
    private int startNumberForDiscount;
    private int limitNumberForDiscount;

    public NamwonPrinterContact() {
    }

    public void setBoughtNumberForDiscount(int boughtNumberForDiscount) {
        this.boughtNumberForDiscount = boughtNumberForDiscount;
    }

    public Organization getOrganization() {
        return organization;
    }

    public int getTotalBoughtNumber() {
        return totalBoughtNumber;
    }

    public int getBoughtNumberForDiscount() {
        return boughtNumberForDiscount;
    }

    public int getStartNumberForDiscount() {
        return startNumberForDiscount;
    }

    public int getLimitNumberForDiscount() {
        return limitNumberForDiscount;
    }

    public NamwonPrinterContact(Organization organization, int totalBoughtNumber, int boughtNumberForDiscount, int startNumberForDiscount, int limitNumberForDiscount) {
        this.organization = organization;
        this.totalBoughtNumber = totalBoughtNumber;
        this.boughtNumberForDiscount = boughtNumberForDiscount;
        this.startNumberForDiscount = startNumberForDiscount;
        this.limitNumberForDiscount = limitNumberForDiscount;
    }
}

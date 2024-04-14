package com.econovation.springstudy.entity;

import jakarta.persistence.*;

@Entity
public class NamwonPrinterContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private NamwonBusiness namwonBusiness;
    private int totalBoughtNumber;
    private int boughtNumberForDiscount;
    private int startNumberForDiscount;
    private int limitNumberForDiscount;

    public NamwonPrinterContact() {
    }

    public void setBoughtNumberForDiscount(int boughtNumberForDiscount) {
        this.boughtNumberForDiscount = boughtNumberForDiscount;
    }

    public NamwonBusiness getNamwonBusiness() {
        return namwonBusiness;
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

    public NamwonPrinterContact(NamwonBusiness namwonBusiness, int totalBoughtNumber, int boughtNumberForDiscount, int startNumberForDiscount, int limitNumberForDiscount) {
        this.namwonBusiness = getNamwonBusiness();
        this.totalBoughtNumber = totalBoughtNumber;
        this.boughtNumberForDiscount = boughtNumberForDiscount;
        this.startNumberForDiscount = startNumberForDiscount;
        this.limitNumberForDiscount = limitNumberForDiscount;
    }
}

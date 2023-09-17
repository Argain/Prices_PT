package com.example.springboot.Model.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ProductDTO implements Serializable {
    // product identifier, chain identifier, rate to apply, dates of application and
    // final price to apply
    private Integer productId;
    private String chainIdentifier;
    private double rate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double priceToApply;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getChainIdentifier() {
        return chainIdentifier;
    }

    public void setChainIdentifier(String chainIdentifier) {
        this.chainIdentifier = chainIdentifier;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public double getPriceToApply() {
        return priceToApply;
    }

    public void setPriceToApply(double priceToApply) {
        this.priceToApply = priceToApply;
    }
}
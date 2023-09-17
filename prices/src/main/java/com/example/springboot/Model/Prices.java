package com.example.springboot.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRICES")
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRICE_LIST", length = 10, nullable = false, unique = false)
    private long priceList;

    private long brandId;

    @Column(name = "START_DATE", length = 50, nullable = false, unique = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE", length = 50, nullable = false, unique = false)
    private LocalDateTime endDate;

    @Column(name = "PRODUCT_ID", length = 50, nullable = false, unique = false)
    private Integer productId;

    @Column(name = "PRIORITY", length = 5, nullable = false, unique = false)
    private Integer priority;

    @Column(name = "PRICE", length = 50, nullable = false, unique = false)
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "CURR", length = 3, nullable = false, unique = false)
    private CURR curr;

    @Column(name = "RATE", length = 50, nullable = false, unique = false)
    private double rate;

    @Column(name = "CHAIN_PRODUCT", length = 8, nullable = false, unique = false)
    private String chainProduct;

    public long getPriceList() {
        return priceList;
    }

    public void setPriceList(long priceList) {
        this.priceList = priceList;
    }

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CURR getCurr() {
        return curr;
    }

    public void setCurr(CURR curr) {
        this.curr = curr;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getChainProduct() {
        return chainProduct;
    }

    public void setChainProduct(String chainProduct) {
        this.chainProduct = chainProduct;
    }

}

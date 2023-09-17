package com.example.springboot.Model.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TestDTO implements Serializable {
    private LocalDateTime applicationDate;
    private Integer productId;
    private String identifier;

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

}
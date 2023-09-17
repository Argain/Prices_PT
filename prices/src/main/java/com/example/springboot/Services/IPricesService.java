package com.example.springboot.Services;

import java.time.LocalDateTime;
import java.util.List;

import com.example.springboot.Model.Prices;

public interface IPricesService {
    List<Prices> getAllPrices();

    Prices getPrice(LocalDateTime applicationDate,
            Integer productId,
            String identifier);
}

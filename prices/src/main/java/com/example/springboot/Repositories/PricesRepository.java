package com.example.springboot.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.springboot.Model.Prices;

public interface PricesRepository extends CrudRepository<Prices, Long> {
    Optional<List<Prices>> findByProductId(Integer productId);
}

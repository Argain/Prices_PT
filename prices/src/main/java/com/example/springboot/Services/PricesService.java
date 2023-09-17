package com.example.springboot.Services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Model.Prices;
import com.example.springboot.Repositories.PricesRepository;

@Service
public class PricesService implements IPricesService {

    @Autowired
    PricesRepository pricesRepository;

    public List<Prices> getAllPrices() {
        List<Prices> prices = new ArrayList<Prices>();
        pricesRepository.findAll().forEach(price -> prices.add(price));
        return prices;
    }

    public Prices getPrice(LocalDateTime applicationDate, Integer productId, String identifier) {
        Optional<List<Prices>> pricesByProductId = pricesRepository.findByProductId(productId);

        if(!pricesByProductId.isPresent())
            return new Prices();

        List<Prices> pricesByApplicationDate = pricesByProductId.get().stream()
                .filter(p -> (p.getStartDate().isBefore(applicationDate)
                        || p.getStartDate().isEqual(applicationDate))
                        && (p.getEndDate().isAfter(applicationDate)
                                || p.getEndDate().isEqual(applicationDate)))
                .collect(Collectors.toList());

         if(pricesByApplicationDate.isEmpty())
            return new Prices();

        List<Prices> pricesByIdentifier = pricesByApplicationDate.stream()
                .filter(p -> p.getBrandId() == Integer.parseInt(identifier))
                .collect(Collectors.toList());

        if(pricesByIdentifier.isEmpty())
            return new Prices();
        
        Collections.sort(pricesByIdentifier, Comparator.comparing(Prices::getPriority).reversed());

        return pricesByIdentifier.get(0);
    }

}

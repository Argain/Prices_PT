package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.Model.Prices;
import com.example.springboot.Model.DTO.ProductDTO;
import com.example.springboot.Services.IPricesService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class PricesController {

    @Autowired
    IPricesService pricesService;

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/prices")
    public ResponseEntity<List<Prices>> getAllPrices() {
        try {
            return new ResponseEntity<>(pricesService.getAllPrices(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/price")
    @ResponseBody
    public ResponseEntity<ProductDTO> getPrice(
            @RequestParam(name = "application_date")  
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
            LocalDateTime applicationDate,
            @RequestParam(name = "product_identifier") Integer productId,
            @RequestParam(name = "identifier") String identifier) {
        try {
            ProductDTO productDTO = new ProductDTO();

            Prices price = pricesService.getPrice(applicationDate, productId, identifier);

            if(price.getProductId() == null)
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

            productDTO.setProductId(price.getProductId());
            productDTO.setChainIdentifier(price.getChainProduct());
            productDTO.setRate(price.getRate());
            productDTO.setStartDate(price.getStartDate());
            productDTO.setEndDate(price.getEndDate());
            productDTO.setPriceToApply(price.getPrice());

            return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

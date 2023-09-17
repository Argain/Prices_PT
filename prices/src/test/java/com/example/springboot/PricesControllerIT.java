package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricesControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/", String.class);
        assertThat(response.getBody()).isEqualTo("Greetings from Spring Boot!");
    }

    @Test
    public void getPrices() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/prices", String.class);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    public void getPriceAt10AMOf14thForProduct35455ForBrand1() throws Exception {
        String time = "2020-06-14T10:00:00";
        LocalDateTime applicationDate = LocalDateTime.parse(time);
        Integer productId = 35455;
        String identifier = "1";

        String URL = "/price?application_date=" + applicationDate + "&product_identifier=" + productId
                + "&identifier=" + identifier;
        ResponseEntity<String> response = testRestTemplate.getForEntity(URL, String.class);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK) == 0);
        assertThat(response.getBody()).isNotEmpty();
        assertThat(response.getBody()).isEqualTo(
                "{\"productId\":35455,\"chainIdentifier\":\"12345678\",\"rate\":18.0,\"startDate\":\"2020-06-14T00:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"priceToApply\":35.5}");
    }

    @Test
    public void getPriceAt04PMOf14thForProduct35455ForBrand1() throws Exception {
        String time = "2020-06-14T16:00:00";
        LocalDateTime applicationDate = LocalDateTime.parse(time);
        Integer productId = 35455;
        String identifier = "1";

        String URL = "/price?application_date=" + applicationDate + "&product_identifier=" + productId
                + "&identifier=" + identifier;
        ResponseEntity<String> response = testRestTemplate.getForEntity(URL, String.class);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK) == 0);
        assertThat(response.getBody()).isNotEmpty();
        assertThat(response.getBody()).isEqualTo(
                "{\"productId\":35455,\"chainIdentifier\":\"12213443\",\"rate\":-15.0,\"startDate\":\"2020-06-14T15:00:00\",\"endDate\":\"2020-06-14T18:30:00\",\"priceToApply\":25.45}");
    }

    @Test
    public void getPriceAt09PMOf14thForProduct35455ForBrand1() throws Exception {
        String time = "2020-06-14T21:00:00";
        LocalDateTime applicationDate = LocalDateTime.parse(time);
        Integer productId = 35455;
        String identifier = "1";

        String URL = "/price?application_date=" + applicationDate + "&product_identifier=" + productId
                + "&identifier=" + identifier;
        ResponseEntity<String> response = testRestTemplate.getForEntity(URL, String.class);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK) == 0);
        assertThat(response.getBody()).isNotEmpty();
        assertThat(response.getBody()).isEqualTo(
                "{\"productId\":35455,\"chainIdentifier\":\"12345678\",\"rate\":18.0,\"startDate\":\"2020-06-14T00:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"priceToApply\":35.5}");
    }

    @Test
    public void getPriceAt10AMOf15thForProduct35455ForBrand1() throws Exception {
        String time = "2020-06-15T10:00:00";
        LocalDateTime applicationDate = LocalDateTime.parse(time);
        Integer productId = 35455;
        String identifier = "1";

        String URL = "/price?application_date=" + applicationDate + "&product_identifier=" + productId
                + "&identifier=" + identifier;
        ResponseEntity<String> response = testRestTemplate.getForEntity(URL, String.class);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK) == 0);
        assertThat(response.getBody()).isNotEmpty();
        assertThat(response.getBody()).isEqualTo(
                "{\"productId\":35455,\"chainIdentifier\":\"12349876\",\"rate\":2.0,\"startDate\":\"2020-06-15T00:00:00\",\"endDate\":\"2020-06-15T11:00:00\",\"priceToApply\":30.5}");
    }

    @Test
    public void getPriceAt09PMOf16thForProduct35455ForBrand1() throws Exception {
        String time = "2020-06-16T21:00:00";
        LocalDateTime applicationDate = LocalDateTime.parse(time);
        Integer productId = 35455;
        String identifier = "1";

        String URL = "/price?application_date=" + applicationDate + "&product_identifier=" + productId
                + "&identifier=" + identifier;
        ResponseEntity<String> response = testRestTemplate.getForEntity(URL, String.class);
        assertThat(response.getStatusCode().compareTo(HttpStatus.OK) == 0);
        assertThat(response.getBody()).isNotEmpty();
        assertThat(response.getBody()).isEqualTo(
                "{\"productId\":35455,\"chainIdentifier\":\"12345678\",\"rate\":18.0,\"startDate\":\"2020-06-14T00:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"priceToApply\":35.5}");
    }

    @Test
    public void getNotFoundPriceBecauseWrongProductId() throws Exception {
        String time = "2020-06-14T10:00:00";
        LocalDateTime applicationDate = LocalDateTime.parse(time);
        Integer productId = 35555;
        String identifier = "1";

        String URL = "/price?application_date=" + applicationDate + "&product_identifier=" + productId
                + "&identifier=" + identifier;
        ResponseEntity<String> response = testRestTemplate.getForEntity(URL, String.class);
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND) == 0);
    }

    @Test
    public void getNotFoundPriceBecauseWrongDate() throws Exception {
        String time = "2020-06-12T10:00:00";
        LocalDateTime applicationDate = LocalDateTime.parse(time);
        Integer productId = 35455;
        String identifier = "1";

        String URL = "/price?application_date=" + applicationDate + "&product_identifier=" + productId
                + "&identifier=" + identifier;
        ResponseEntity<String> response = testRestTemplate.getForEntity(URL, String.class);
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND) == 0);
    }

    @Test
    public void getNotFoundPriceBecauseWrongBrand() throws Exception {
        String time = "2020-06-12T10:00:00";
        LocalDateTime applicationDate = LocalDateTime.parse(time);
        Integer productId = 35455;
        String identifier = "3";

        String URL = "/price?application_date=" + applicationDate + "&product_identifier=" + productId
                + "&identifier=" + identifier;
        ResponseEntity<String> response = testRestTemplate.getForEntity(URL, String.class);
        assertThat(response.getStatusCode().compareTo(HttpStatus.NOT_FOUND) == 0);
    }

}

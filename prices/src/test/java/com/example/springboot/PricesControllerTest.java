package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureMockMvc
public class PricesControllerTest {

        @Autowired
        private MockMvc mvc;

        @Test
        public void getHello() throws Exception {
                mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
        }

        @Test
        public void getPrices() throws Exception {
                mvc.perform(MockMvcRequestBuilders.get("/prices").accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(content().contentType("application/json"));
        }

        @Test
        public void getPriceAt10AMOf14thForProduct35455ForBrand1() throws Exception {                
                String time = "2020-06-14T10:00:00";
                LocalDateTime applicationDate = LocalDateTime.parse(time);
                Integer productId = 35455;
                String identifier = "1";

                String URL = "/price?application_date=" + applicationDate + "&product_identifier=" + productId
                                + "&identifier="
                                + identifier;

                mvc.perform(MockMvcRequestBuilders.get(URL)
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(content().contentType("application/json"))
                                .andExpect(jsonPath("$.productId", is(35455)))
                                .andExpect(jsonPath("$.chainIdentifier", is("12345678")))
                                .andExpect(jsonPath("$.rate", is(18.0)))
                                .andExpect(jsonPath("$.startDate", is("2020-06-14T00:00:00")))
                                .andExpect(jsonPath("$.endDate", is("2020-12-31T23:59:59")))
                                .andExpect(jsonPath("$.priceToApply", is(35.5)));
        }

        @Test
        public void getPriceAt04PMOf14thForProduct35455ForBrand1() throws Exception {
                String time = "2020-06-14T16:00:00";
                LocalDateTime applicationDate = LocalDateTime.parse(time);
                Integer productId = 35455;
                String identifier = "1";

                String URL = "/price?application_date=" + applicationDate + "&product_identifier=" + productId
                                + "&identifier="
                                + identifier;

                mvc.perform(MockMvcRequestBuilders.get(URL)
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(content().contentType("application/json"))
                                .andExpect(jsonPath("$.productId", is(35455)))
                                .andExpect(jsonPath("$.chainIdentifier", is("12213443")))
                                .andExpect(jsonPath("$.rate", is(-15.0)))
                                .andExpect(jsonPath("$.startDate", is("2020-06-14T15:00:00")))
                                .andExpect(jsonPath("$.endDate", is("2020-06-14T18:30:00")))
                                .andExpect(jsonPath("$.priceToApply", is(25.45)));
        }

        @Test
        public void getPriceAt09PMOf14thForProduct35455ForBrand1() throws Exception {             
                String time = "2020-06-14T21:00:00";
                LocalDateTime applicationDate = LocalDateTime.parse(time);
                Integer productId = 35455;
                String identifier = "1";

                String URL = "/price?application_date=" + applicationDate + "&product_identifier=" + productId
                                + "&identifier="
                                + identifier;

                mvc.perform(MockMvcRequestBuilders.get(URL)
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(content().contentType("application/json"))
                                .andExpect(jsonPath("$.productId", is(35455)))
                                .andExpect(jsonPath("$.chainIdentifier", is("12345678")))
                                .andExpect(jsonPath("$.rate", is(18.0)))
                                .andExpect(jsonPath("$.startDate", is("2020-06-14T00:00:00")))
                                .andExpect(jsonPath("$.endDate", is("2020-12-31T23:59:59")))
                                .andExpect(jsonPath("$.priceToApply", is(35.5)));
        }

        @Test
        public void getPriceAt10AMOf15thForProduct35455ForBrand1() throws Exception {
                String time = "2020-06-15T10:00:00";
                LocalDateTime applicationDate = LocalDateTime.parse(time);
                Integer productId = 35455;
                String identifier = "1";

                String URL = "/price?application_date=" + applicationDate + "&product_identifier=" + productId
                                + "&identifier="
                                + identifier;

                mvc.perform(MockMvcRequestBuilders.get(URL)
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(content().contentType("application/json"))
                                .andExpect(jsonPath("$.productId", is(35455)))
                                .andExpect(jsonPath("$.chainIdentifier", is("12349876")))
                                .andExpect(jsonPath("$.rate", is(2.0)))
                                .andExpect(jsonPath("$.startDate", is("2020-06-15T00:00:00")))
                                .andExpect(jsonPath("$.endDate", is("2020-06-15T11:00:00")))
                                .andExpect(jsonPath("$.priceToApply", is(30.5)));
        }

        @Test
        public void getPriceAt09PMOf16thForProduct35455ForBrand1() throws Exception {
                String time = "2020-06-16T21:00:00";
                LocalDateTime applicationDate = LocalDateTime.parse(time);
                Integer productId = 35455;
                String identifier = "1";

                String URL = "/price?application_date=" + applicationDate + "&product_identifier=" + productId
                                + "&identifier="
                                + identifier;

                mvc.perform(MockMvcRequestBuilders.get(URL)
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andExpect(content().contentType("application/json"))
                                .andExpect(jsonPath("$.productId", is(35455)))
                                .andExpect(jsonPath("$.chainIdentifier", is("12345678")))
                                .andExpect(jsonPath("$.rate", is(18.0)))
                                .andExpect(jsonPath("$.startDate", is("2020-06-14T00:00:00")))
                                .andExpect(jsonPath("$.endDate", is("2020-12-31T23:59:59")))
                                .andExpect(jsonPath("$.priceToApply", is(35.5)));
        }

        @Test
        public void getNotFoundPriceBecauseWrongProductId() throws Exception {
                String time = "2020-06-14T10:00:00";
                LocalDateTime applicationDate = LocalDateTime.parse(time);
                Integer productId = 35555;
                String identifier = "1";

                String URL = "/price?application_date=" + applicationDate + "&product_identifier=" + productId
                                + "&identifier="
                                + identifier;

                mvc.perform(MockMvcRequestBuilders.get(URL)
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isNotFound());
        }

        @Test
        public void getNotFoundPriceBecauseWrongDate() throws Exception {
                String time = "2020-06-12T10:00:00";
                LocalDateTime applicationDate = LocalDateTime.parse(time);
                Integer productId = 35455;
                String identifier = "1";

                String URL = "/price?application_date=" + applicationDate + "&product_identifier=" + productId
                                + "&identifier="
                                + identifier;

                mvc.perform(MockMvcRequestBuilders.get(URL)
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isNotFound());
        }

        @Test
        public void getNotFoundPriceBecauseWrongBrand() throws Exception {
                String time = "2020-06-14T10:00:00";
                LocalDateTime applicationDate = LocalDateTime.parse(time);
                Integer productId = 35455;
                String identifier = "3";

                String URL = "/price?application_date=" + applicationDate + "&product_identifier=" + productId
                                + "&identifier="
                                + identifier;

                mvc.perform(MockMvcRequestBuilders.get(URL)
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().is4xxClientError());
        }

}
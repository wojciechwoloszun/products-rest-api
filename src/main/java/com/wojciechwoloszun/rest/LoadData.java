package com.wojciechwoloszun.rest;

import com.wojciechwoloszun.rest.model.Product;
import com.wojciechwoloszun.rest.model.ProductStatistic;
import com.wojciechwoloszun.rest.model.ProductType;
import com.wojciechwoloszun.rest.repository.ProductRepository;
import com.wojciechwoloszun.rest.repository.ProductStatisticRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadData {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductStatisticRepository productStatisticRepository;

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository, ProductStatisticRepository productStatisticRepository) {
        return args -> {
            createProduct("Skirt", "Long skirt for girl.", ProductType.KID, 100);
            createProduct("Trousers", "Trousers for male.", ProductType.MALE, 50);
            createProduct("Dress", "Dress for female.", ProductType.FEMALE, 50);

        };
    }



    private void createProduct(String name, String description, ProductType productType, double price) {
        Product product = productRepository.save(new Product(name, description, productType, price));
        productStatisticRepository.save(new ProductStatistic(product));
    }


}
package com.wojciechwoloszun.rest.controller;

import com.wojciechwoloszun.rest.repository.ProductRepository;
import com.wojciechwoloszun.rest.repository.ProductStatisticRepository;
import com.wojciechwoloszun.rest.model.Product;
import com.wojciechwoloszun.rest.model.ProductStatistic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductStatisticRepository productStatisticRepository;


    public ProductController(ProductRepository productRepository, ProductStatisticRepository productStatisticRepository) {
        this.productRepository = productRepository;
        this.productStatisticRepository = productStatisticRepository;
    }

    @GetMapping("/products/{id}")
    Product getProduct(@PathVariable Long id) {
        updateProductStatistic(id);
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    private void updateProductStatistic(Long productId) {
        ProductStatistic productStatistic = productStatisticRepository.findByProductId(productId);
        if (productStatistic == null) {
            throw new ProductNotFoundException(productId);
        }

        int numberOfViews = productStatistic.getNumberOfViews();
        productStatistic.setNumberOfViews(numberOfViews + 1);
        productStatisticRepository.save(productStatistic);
    }

}

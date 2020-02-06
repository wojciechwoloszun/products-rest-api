package com.wojciechwoloszun.rest.controller;

import com.wojciechwoloszun.rest.repository.ProductStatisticRepository;
import com.wojciechwoloszun.rest.model.ProductStatistic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductStatisticController {

    private final ProductStatisticRepository productStatisticRepository;

    public ProductStatisticController(ProductStatisticRepository productStatisticRepository) {
        this.productStatisticRepository = productStatisticRepository;
    }

    @GetMapping("/product-number-of-views/{id}")
    int productNumberOfViews(@PathVariable Long id) {
        ProductStatistic productStatistic = productStatisticRepository.findByProductId(id);
        if (productStatistic == null) {
            throw new ProductNotFoundException(id);
        }
        return productStatistic.getNumberOfViews();
    }


}

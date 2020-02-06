package com.wojciechwoloszun.rest.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductStatistic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;


    private int numberOfViews = 0;

    public ProductStatistic() {
    }


    public ProductStatistic(Product product) {
        this.product = product;
    }
}

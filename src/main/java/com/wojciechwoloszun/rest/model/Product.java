package com.wojciechwoloszun.rest.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private ProductType type;
    private double price;
    @Transient
    private Discount discount;


    public Product() {
    }

    public Product(String name, String description, ProductType type, double price) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
        setDiscount();
    }

    private void setDiscount() {
        if (this.type.equals(ProductType.KID)) {
            this.discount = new KidDiscount();
        } else if (this.type.equals(ProductType.MALE)) {
            this.discount = new MaleDiscount();
        } else if (this.type.equals(ProductType.FEMALE)) {
            this.discount = new FemaleDiscount();
        } else {
            //throw new Exception("Unknown product type");
        }
    }

    public void setType(ProductType type) {
        this.type = type;
        setDiscount();
    }

    public double getFinalPrice(){
        double discount = getDiscount().calculateDiscount(price);
        return price-discount;
    }
}

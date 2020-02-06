package com.wojciechwoloszun.rest.model;

public class FemaleDiscount implements Discount {
    @Override
    public double calculateDiscount(double price) {
        return (price * 0.05);
    }
}

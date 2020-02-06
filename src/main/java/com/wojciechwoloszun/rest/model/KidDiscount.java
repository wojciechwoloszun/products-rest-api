package com.wojciechwoloszun.rest.model;

public class KidDiscount implements Discount {
    @Override
    public double calculateDiscount(double price) {
        return (price * 0.1);
    }
}

package com.wojciechwoloszun.rest.model;

public class MaleDiscount implements Discount {
    @Override
    public double calculateDiscount(double price) {
        return (price * 0.05);
    }
}

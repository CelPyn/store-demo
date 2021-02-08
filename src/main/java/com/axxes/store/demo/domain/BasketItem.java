package com.axxes.store.demo.domain;

public interface BasketItem {

    Product getProduct();

    int getQuantity();

    double getSubtotal();
}

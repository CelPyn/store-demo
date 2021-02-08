package com.axxes.store.demo.domain.impl;

import java.util.StringJoiner;

import com.axxes.store.demo.domain.BasketItem;
import com.axxes.store.demo.domain.Product;

public class DefaultBasketItem implements BasketItem {

    private final Product product;
    private final int quantity;

    public DefaultBasketItem(final Product product, final int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public double getSubtotal() {
        return 0;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DefaultBasketItem.class.getSimpleName() + "[", "]").add("product=" + product)
                    .add("quantity=" + quantity)
                    .toString();
    }
}

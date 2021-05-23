package com.axxes.store.demo.domain.impl;

import com.axxes.store.demo.domain.BasketItem;
import com.axxes.store.demo.domain.Product;

import java.util.Objects;
import java.util.StringJoiner;

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
        return product.getPrice() * quantity;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final DefaultBasketItem that = (DefaultBasketItem) o;
        return quantity == that.quantity && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DefaultBasketItem.class.getSimpleName() + "[", "]").add("product=" + product)
                    .add("quantity=" + quantity)
                    .toString();
    }
}

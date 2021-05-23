package com.axxes.store.demo.service.impl;

import com.axxes.store.demo.domain.Basket;
import com.axxes.store.demo.domain.BasketItem;
import com.axxes.store.demo.domain.Product;
import com.axxes.store.demo.domain.impl.DefaultBasketItem;
import com.axxes.store.demo.service.BasketService;

public class DefaultBasketService implements BasketService {

    @Override
    public Basket add(final Basket basket, final Product product, final int quantity) {
        boolean replacedExisting = false;
        for (final BasketItem basketItem : basket.getContent()) {
            if (basketItem.getProduct().equals(product)) {
                final BasketItem newItem = new DefaultBasketItem(product, basketItem.getQuantity() + quantity);
                basket.getContent().remove(basketItem);
                basket.getContent().add(newItem);
                replacedExisting = true;
                break;
            }
        }

        if (!replacedExisting) {
            final BasketItem newItem = new DefaultBasketItem(product, quantity);
            basket.getContent().add(newItem);
        }

        return basket;
    }

    @Override
    public Basket remove(final Basket basket, final int id, final int quantity) {
        throw new RuntimeException();
    }
}

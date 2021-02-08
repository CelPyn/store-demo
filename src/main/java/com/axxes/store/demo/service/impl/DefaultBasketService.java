package com.axxes.store.demo.service.impl;

import com.axxes.store.demo.domain.Basket;
import com.axxes.store.demo.domain.Product;
import com.axxes.store.demo.service.BasketService;

public class DefaultBasketService implements BasketService {

    @Override
    public Basket add(final Basket basket, final Product product, final int quantity) {
        throw new RuntimeException();
    }
}

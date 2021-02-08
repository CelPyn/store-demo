package com.axxes.store.demo.service.impl;

import java.util.List;

import com.axxes.store.demo.domain.Basket;
import com.axxes.store.demo.domain.BasketItem;
import com.axxes.store.demo.domain.Product;
import com.axxes.store.demo.domain.impl.DefaultBasket;
import com.axxes.store.demo.domain.impl.DefaultBasketItem;
import com.axxes.store.demo.service.BasketService;

public class DefaultBasketService implements BasketService {

    @Override
    public Basket add(final Basket basket, final Product product, final int quantity) {
        final BasketItem basketItem = new DefaultBasketItem(product, quantity);

        final List<BasketItem> content = basket.getContent();
        content.add(basketItem);

        return new DefaultBasket(content);
    }
}

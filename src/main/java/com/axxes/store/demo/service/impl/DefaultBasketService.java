package com.axxes.store.demo.service.impl;

import com.axxes.store.demo.domain.Basket;
import com.axxes.store.demo.domain.BasketItem;
import com.axxes.store.demo.domain.Product;
import com.axxes.store.demo.service.BasketService;

import java.util.List;
import java.util.function.Predicate;

public class DefaultBasketService implements BasketService {

    @Override
    public Basket add(final Basket basket, final Product product, final int quantity) {
        final List<BasketItem> originalContent = basket.getContent();

        final boolean alreadyContainsProduct = originalContent.stream().anyMatch(filterByIdPredicate(product));
        if (alreadyContainsProduct) {
            originalContent.stream().filter(filterByIdPredicate(product));
        }
    }

    private Predicate<BasketItem> filterByIdPredicate(final Product product) {
        return basketItem -> basketItem.getProduct().getId() == product.getId();
    }

    @Override
    public Basket remove(final Basket basket, final int id, final int quantity) {
        throw new RuntimeException();
    }
}

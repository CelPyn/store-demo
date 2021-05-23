package com.axxes.store.demo.service.impl;

import com.axxes.store.demo.domain.Basket;
import com.axxes.store.demo.domain.BasketItem;
import com.axxes.store.demo.domain.Product;
import com.axxes.store.demo.domain.impl.DefaultBasketItem;
import com.axxes.store.demo.service.BasketService;

import java.util.List;

public class DefaultBasketService implements BasketService {

    @Override
    public Basket add(final Basket basket, final Product product, final int quantity) {
        if (product == null || basket == null) {
            throw new RuntimeException("Cannot add null product or add to null basket");
        }

        final List<BasketItem> content = basket.getContent();
        for (final BasketItem basketItem : content) {
            if (basketItem.getProduct().equals(product)) {
                final BasketItem newItem = new DefaultBasketItem(product, basketItem.getQuantity() + quantity);
                content.remove(basketItem);
                content.add(newItem);
                return basket;
            }
        }

        final BasketItem newItem = new DefaultBasketItem(product, quantity);
        content.add(newItem);

        return basket;
    }

    @Override
    public Basket remove(final Basket basket, final int id, final int quantity) {
        if (basket == null) {
            throw new RuntimeException("Cannot remove from null basket");
        }

        final List<BasketItem> content = basket.getContent();
        for (final BasketItem basketItem : content) {
            final Product product = basketItem.getProduct();
            if (product.getId() == id) {

                final int originalQuantity = basketItem.getQuantity();
                if (originalQuantity > quantity) {
                    final BasketItem newItem = new DefaultBasketItem(product, originalQuantity - quantity);
                    content.remove(basketItem);
                    content.add(newItem);
                    return basket;
                }

                if (originalQuantity == quantity) {
                    content.remove(basketItem);
                    return basket;
                }

                throw new RuntimeException("Cannot remove more of a product than exists in the basket");
            }
        }

        throw new RuntimeException("Basket did not contain product with id " + id);
    }
}

package com.axxes.store.demo.domain.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import com.axxes.store.demo.domain.Basket;
import com.axxes.store.demo.domain.BasketItem;

public class DefaultBasket implements Basket {

    private final List<BasketItem> content;

    public DefaultBasket() {
        content = new ArrayList<>();
    }

    public DefaultBasket(final List<BasketItem> content) {
        this.content = content;
    }

    @Override
    public List<BasketItem> getContent() {
        return content;
    }

    @Override
    public double getTotal() {
        return content.stream().mapToDouble(BasketItem::getSubtotal).sum();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DefaultBasket.class.getSimpleName() + "[", "]").toString();
    }
}

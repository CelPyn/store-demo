package com.axxes.store.demo.domain.impl;

import com.axxes.store.demo.domain.Basket;
import com.axxes.store.demo.domain.BasketItem;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class DefaultBasket implements Basket {

    private final List<BasketItem> content;

    public DefaultBasket(final List<BasketItem> content) {
        this.content = content;
    }

    @Override
    public List<BasketItem> getContent() {
        return content;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final DefaultBasket that = (DefaultBasket) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DefaultBasket.class.getSimpleName() + "[", "]").toString();
    }
}

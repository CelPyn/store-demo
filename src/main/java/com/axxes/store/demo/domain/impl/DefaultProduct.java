package com.axxes.store.demo.domain.impl;

import java.util.StringJoiner;

import com.axxes.store.demo.domain.Category;
import com.axxes.store.demo.domain.Product;

public class DefaultProduct implements Product {

    private final int id;
    private final String name;
    private final double price;
    private final Category category;

    public DefaultProduct(final int id, final String name, final double price, final Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DefaultProduct.class.getSimpleName() + "[", "]").add("id=" + id)
                    .add("name='" + name + "'")
                    .add("price=" + price)
                    .add("category=" + category)
                    .toString();
    }
}

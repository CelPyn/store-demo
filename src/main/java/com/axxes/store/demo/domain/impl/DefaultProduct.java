package com.axxes.store.demo.domain.impl;

import com.axxes.store.demo.domain.Category;
import com.axxes.store.demo.domain.Product;

import java.util.Objects;
import java.util.StringJoiner;

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
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final DefaultProduct that = (DefaultProduct) o;
        return id == that.id && Double.compare(that.price, price) == 0 && Objects.equals(name, that.name) && category == that.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, category);
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

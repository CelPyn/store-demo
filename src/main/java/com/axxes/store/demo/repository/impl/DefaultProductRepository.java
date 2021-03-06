package com.axxes.store.demo.repository.impl;

import com.axxes.store.demo.domain.Category;
import com.axxes.store.demo.domain.Product;
import com.axxes.store.demo.domain.impl.DefaultProduct;
import com.axxes.store.demo.repository.ProductRepository;

import java.util.List;
import java.util.function.Predicate;

public class DefaultProductRepository implements ProductRepository {

    private final Product[] products = {                                                           //
                new DefaultProduct(1, "Leffe", 3.4, Category.DRINK),                //
                new DefaultProduct(2, "Spa 1L", 2.1, Category.DRINK),               //
                new DefaultProduct(3, "Doritos 250gr", 1.8, Category.FOOD),         //
                new DefaultProduct(4, "Nutella 750gr", 2.6, Category.FOOD),         //
                new DefaultProduct(5, "T-shirt (zwart)", 15.20, Category.FASHION),  //
                new DefaultProduct(6, "T-shirt (wit)", 15.20, Category.FASHION),    //
                new DefaultProduct(7, "Channel no. 5", 65.99, Category.BEAUTY),     //
                new DefaultProduct(8, "Eyeliner", 24.49, Category.BEAUTY)           //
    };

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product getById(final int id) {
        return null;
    }

    @Override
    public List<Product> find(final Predicate<Product> predicate) {
        return null;
    }

    @Override
    public List<Product> findByCategory(final Category category) {
        return null;
    }

    @Override
    public List<Product> findByName(final String name) {
        return null;
    }
}

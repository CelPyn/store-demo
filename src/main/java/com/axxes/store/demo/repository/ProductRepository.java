package com.axxes.store.demo.repository;

import com.axxes.store.demo.domain.Category;
import com.axxes.store.demo.domain.Product;

import java.util.List;
import java.util.function.Predicate;

public interface ProductRepository {

    List<Product> getProducts();

    Product getById(int id);

    List<Product> find(Predicate<Product> predicate);

    List<Product> findByCategory(Category category);

    List<Product> findByName(String name);
}

package com.axxes.store.demo.service;

import java.util.List;

import com.axxes.store.demo.domain.Category;
import com.axxes.store.demo.domain.Product;

public interface CatalogService {

    List<Product> getAll();

    Product getById(String id);

    List<Product> searchByCategory(Category category);

    List<Product> searchByName(String name);
}

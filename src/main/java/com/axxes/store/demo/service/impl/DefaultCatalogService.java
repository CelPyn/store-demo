package com.axxes.store.demo.service.impl;

import java.util.List;

import com.axxes.store.demo.domain.Category;
import com.axxes.store.demo.domain.Product;
import com.axxes.store.demo.repository.ProductRepository;
import com.axxes.store.demo.service.CatalogService;

public class DefaultCatalogService implements CatalogService {

    private final ProductRepository repository;

    public DefaultCatalogService(final ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAll() {
        throw new RuntimeException();
    }

    @Override
    public Product getById(final String id) {
        throw new RuntimeException();
    }

    @Override
    public List<Product> searchByCategory(final Category category) {
        throw new RuntimeException();
    }

    @Override
    public List<Product> searchByName(final String name) {
        throw new RuntimeException();
    }
}

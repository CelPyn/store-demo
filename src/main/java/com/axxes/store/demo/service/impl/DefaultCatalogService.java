package com.axxes.store.demo.service.impl;

import com.axxes.store.demo.domain.Category;
import com.axxes.store.demo.domain.Product;
import com.axxes.store.demo.repository.ProductRepository;
import com.axxes.store.demo.service.CatalogService;

import java.util.List;

public class DefaultCatalogService implements CatalogService {

    private final ProductRepository repository;

    public DefaultCatalogService(final ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAll() {
        return repository.getProducts();
    }

    @Override
    public Product getById(final String id) {
        final int parsedId = Integer.parseInt(id);
        return repository.getById(parsedId);
    }

    @Override
    public List<Product> searchByCategory(final Category category) {
        return repository.findByCategory(category);
    }

    @Override
    public List<Product> searchByName(final String name) {
        return repository.findByName(name);
    }
}

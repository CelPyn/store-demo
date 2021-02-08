package com.axxes.store.demo.repository;

import java.util.List;

import com.axxes.store.demo.domain.Product;

public interface ProductRepository {

    List<Product> getProducts();
}

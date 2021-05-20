package com.axxes.store.demo.service;

import com.axxes.store.demo.domain.Basket;
import com.axxes.store.demo.domain.Product;

public interface BasketService {

    Basket add(Basket basket, Product product, int quantity);

    Basket remove(Basket basket, int id, int quantity);
}

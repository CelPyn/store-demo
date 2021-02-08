package com.axxes.store.demo;

import com.axxes.store.demo.repository.ProductRepository;
import com.axxes.store.demo.repository.impl.DefaultProductRepository;
import com.axxes.store.demo.service.BasketService;
import com.axxes.store.demo.service.CatalogService;
import com.axxes.store.demo.service.PayService;
import com.axxes.store.demo.service.impl.DefaultBasketService;
import com.axxes.store.demo.service.impl.DefaultCatalogService;
import com.axxes.store.demo.service.impl.DefaultPayService;

public class Main {

    public static void main(final String[] args) {
        final ProductRepository repository = new DefaultProductRepository();
        final CatalogService catalogService = new DefaultCatalogService(repository);

        final BasketService basketService = new DefaultBasketService();

        final PayService payService = new DefaultPayService();

        System.out.println(catalogService.getAll());
    }
}

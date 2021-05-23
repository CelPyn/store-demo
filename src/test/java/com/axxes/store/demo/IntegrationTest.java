package com.axxes.store.demo;

import com.axxes.store.demo.domain.Basket;
import com.axxes.store.demo.domain.Category;
import com.axxes.store.demo.domain.Product;
import com.axxes.store.demo.domain.impl.DefaultBasket;
import com.axxes.store.demo.repository.ProductRepository;
import com.axxes.store.demo.repository.impl.DefaultProductRepository;
import com.axxes.store.demo.service.BasketService;
import com.axxes.store.demo.service.CatalogService;
import com.axxes.store.demo.service.PayService;
import com.axxes.store.demo.service.impl.DefaultBasketService;
import com.axxes.store.demo.service.impl.DefaultCatalogService;
import com.axxes.store.demo.service.impl.DefaultPayService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest {

    private static final ProductRepository REPOSITORY = new DefaultProductRepository();
    private static final CatalogService CATALOG_SERVICE = new DefaultCatalogService(REPOSITORY);
    private static final BasketService BASKET_SERVICE = new DefaultBasketService();
    private static final PayService PAY_SERVICE = new DefaultPayService();

    @Test
    void integration() {
        final List<Product> products = CATALOG_SERVICE.searchByCategory(Category.FOOD);

        final Basket basket = new DefaultBasket(new ArrayList<>());

        products.forEach(product -> BASKET_SERVICE.add(basket, product, 4));

        final double total = PAY_SERVICE.getTotal(basket);
        assertThat(total).isNotNull().isEqualTo(17.6);
    }
}

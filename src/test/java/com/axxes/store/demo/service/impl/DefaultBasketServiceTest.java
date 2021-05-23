package com.axxes.store.demo.service.impl;

import com.axxes.store.demo.domain.Basket;
import com.axxes.store.demo.domain.BasketItem;
import com.axxes.store.demo.domain.Product;
import com.axxes.store.demo.domain.impl.DefaultBasket;
import com.axxes.store.demo.domain.impl.DefaultBasketItem;
import com.axxes.store.demo.service.BasketService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class DefaultBasketServiceTest {

    private final BasketService SERVICE = new DefaultBasketService();

    @Test
    void add_happyFlow() {
        final Product product = mock(Product.class);
        final DefaultBasket basket = new DefaultBasket(new ArrayList<>());

        final Basket result = SERVICE.add(basket, product, 1);

        final BasketItem expected = new DefaultBasketItem(product, 1);

        assertThat(result.getContent()).isNotEmpty().hasSize(1);
        assertThat(result.getContent().get(0)).isNotNull().isEqualTo(expected);
    }
}

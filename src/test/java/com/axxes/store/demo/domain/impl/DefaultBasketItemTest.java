package com.axxes.store.demo.domain.impl;

import com.axxes.store.demo.domain.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultBasketItemTest {

    private static final Product MOCK = mock(Product.class);

    @Test
    void subtotal_oneItemInBasketItem() {
        final DefaultBasketItem basketItem = new DefaultBasketItem(MOCK, 1);

        final double price = 1.2;
        when(MOCK.getPrice()).thenReturn(price);

        assertThat(basketItem.getProduct()).isNotNull().isEqualTo(MOCK);
        assertThat(basketItem.getQuantity()).isNotNull().isEqualTo(1);
        assertThat(basketItem.getSubtotal()).isNotNull().isEqualTo(price);
    }

    @Test
    void subtotal_mutlipleItemInBasketItem() {
        final DefaultBasketItem basketItem = new DefaultBasketItem(MOCK, 4);

        final double price = 1.2;
        when(MOCK.getPrice()).thenReturn(price);

        assertThat(basketItem.getProduct()).isNotNull().isEqualTo(MOCK);
        assertThat(basketItem.getQuantity()).isNotNull().isEqualTo(4);
        assertThat(basketItem.getSubtotal()).isNotNull().isEqualTo(price * 4);
    }
}

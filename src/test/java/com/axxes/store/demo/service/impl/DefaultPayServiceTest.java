package com.axxes.store.demo.service.impl;

import com.axxes.store.demo.domain.Basket;
import com.axxes.store.demo.domain.BasketItem;
import com.axxes.store.demo.domain.Product;
import com.axxes.store.demo.domain.impl.DefaultBasket;
import com.axxes.store.demo.domain.impl.DefaultBasketItem;
import com.axxes.store.demo.service.PayService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultPayServiceTest {

    private static final PayService SERVICE = new DefaultPayService();

    @Test
    void getTotal() {
        final Product firstProduct = mock(Product.class);
        when(firstProduct.getPrice()).thenReturn(1.5);
        final Product secondProduct = mock(Product.class);
        when(secondProduct.getPrice()).thenReturn(2.6);

        final BasketItem firstItem = new DefaultBasketItem(firstProduct, 2);
        final BasketItem secondItem = new DefaultBasketItem(firstProduct, 2);
        final List<BasketItem> startContent = List.of(firstItem, secondItem);
        final Basket basket = new DefaultBasket(new ArrayList<>(startContent));

        final double result = SERVICE.getTotal(basket);
        assertThat(result).isNotNull().isEqualTo(firstItem.getSubtotal() + secondItem.getSubtotal());
    }
}

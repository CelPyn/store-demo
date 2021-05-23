package com.axxes.store.demo.service.impl;

import com.axxes.store.demo.domain.Basket;
import com.axxes.store.demo.domain.BasketItem;
import com.axxes.store.demo.domain.Product;
import com.axxes.store.demo.domain.impl.DefaultBasket;
import com.axxes.store.demo.domain.impl.DefaultBasketItem;
import com.axxes.store.demo.service.BasketService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultBasketServiceTest {

    private final BasketService SERVICE = new DefaultBasketService();

    @Test
    void add_happyFlow() {
        final Product product = mock(Product.class);
        final Basket basket = new DefaultBasket(new ArrayList<>());

        final Basket result = SERVICE.add(basket, product, 1);

        final BasketItem expected = new DefaultBasketItem(product, 1);

        assertThat(result.getContent()).isNotEmpty().hasSize(1);
        assertThat(result.getContent().get(0)).isNotNull().isEqualTo(expected);
    }

    @Test
    void add_containsOne_ofDifferentId() {
        final Product product = mock(Product.class);
        final BasketItem startItem = new DefaultBasketItem(product, 1);
        final List<BasketItem> startContent = List.of(startItem);
        final Basket basket = new DefaultBasket(new ArrayList<>(startContent));

        final Product secondProduct = mock(Product.class);

        final Basket result = SERVICE.add(basket, secondProduct, 1);

        final BasketItem expected = new DefaultBasketItem(secondProduct, 1);

        assertThat(result.getContent()).isNotEmpty().hasSize(2).containsExactlyInAnyOrder(startItem, expected);
    }

    @Test
    void add_containsOne_ofSameId() {
        final Product product = mock(Product.class);
        final BasketItem startItem = new DefaultBasketItem(product, 1);
        final List<BasketItem> startContent = List.of(startItem);
        final Basket basket = new DefaultBasket(new ArrayList<>(startContent));

        final Basket result = SERVICE.add(basket, product, 2);

        final BasketItem expected = new DefaultBasketItem(product, 3);

        assertThat(result.getContent()).isNotEmpty().hasSize(1).containsExactlyInAnyOrder(expected);
    }

    @Test
    void add_null() {
        final Product product = mock(Product.class);
        final BasketItem startItem = new DefaultBasketItem(product, 1);
        final List<BasketItem> startContent = List.of(startItem);
        final Basket basket = new DefaultBasket(new ArrayList<>(startContent));

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> SERVICE.add(basket, null, 2));
    }

    @Test
    void add_to_nullBasket() {
        final Product product = mock(Product.class);

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> SERVICE.add(null, product, 2));
    }

    @Test
    void remove_happyFlow() {
        final Product product = mock(Product.class);
        when(product.getId()).thenReturn(1);

        final BasketItem startItem = new DefaultBasketItem(product, 2);
        final List<BasketItem> startContent = List.of(startItem);
        final Basket basket = new DefaultBasket(new ArrayList<>(startContent));

        final Basket result = SERVICE.remove(basket, 1, 1);

        final BasketItem expected = new DefaultBasketItem(product, 1);

        assertThat(result.getContent()).isNotEmpty().hasSize(1).containsExactlyInAnyOrder(expected);
    }

    @Test
    void remove_didNotContainSameId() {
        final Product product = mock(Product.class);
        when(product.getId()).thenReturn(1);

        final BasketItem startItem = new DefaultBasketItem(product, 2);
        final List<BasketItem> startContent = List.of(startItem);
        final Basket basket = new DefaultBasket(new ArrayList<>(startContent));

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> SERVICE.remove(basket, 2, 1));
    }

    @Test
    void remove_emptyBasket() {
        final Basket basket = new DefaultBasket(new ArrayList<>());

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> SERVICE.remove(basket, 2, 1));
    }

    @Test
    void remove_hasLessThanToRemoveQuantity() {
        final Product product = mock(Product.class);
        when(product.getId()).thenReturn(1);

        final BasketItem startItem = new DefaultBasketItem(product, 2);
        final List<BasketItem> startContent = List.of(startItem);
        final Basket basket = new DefaultBasket(new ArrayList<>(startContent));

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> SERVICE.remove(basket, 2, 3));
    }
}

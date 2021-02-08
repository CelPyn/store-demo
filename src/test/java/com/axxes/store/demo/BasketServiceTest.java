package com.axxes.store.demo;

import java.util.List;

import com.axxes.store.demo.domain.Basket;
import com.axxes.store.demo.domain.BasketItem;
import com.axxes.store.demo.domain.Product;
import com.axxes.store.demo.domain.impl.DefaultBasket;
import com.axxes.store.demo.service.BasketService;
import com.axxes.store.demo.service.impl.DefaultBasketService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BasketServiceTest {

    private final BasketService basketService = new DefaultBasketService();

    @Test
    void happyFlow() {
        // Setup
        final Product mockProduct = mock(Product.class);
        when(mockProduct.getPrice()).thenReturn(2.0);

        final Basket basket = new DefaultBasket();

        // Execution
        final Basket result = basketService.add(basket, mockProduct, 5);

        // Assertion
        assertThat(result).isNotNull();

        final List<BasketItem> resultContent = result.getContent();
        assertThat(resultContent).isNotNull().hasSize(1);

        assertThat(resultContent.get(0)).isNotNull();
        assertThat(resultContent.get(0).getQuantity()).isEqualTo(5);
        assertThat(resultContent.get(0).getSubtotal()).isEqualTo(10.0);
        assertThat(resultContent.get(0).getProduct()).isEqualTo(mockProduct);

        assertThat(result.getTotal()).isEqualTo(10.0);
    }

    /**
     * Do not change the setup of this test.
     * Change the implementation in such a way that you can copy the execution and assertion steps
     * from the happyFlow test and have a green test.
     */
    @Test
    void immutability() {
        // Setup
        final Product mockProduct = mock(Product.class);
        when(mockProduct.getPrice()).thenReturn(2.0);

        final Basket basket = new DefaultBasket(List.of());

        // Execution & assertion
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> basketService.add(basket, mockProduct, 5));
    }
}

package com.axxes.store.demo.domain.impl;

import com.axxes.store.demo.domain.Category;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultProductTest {

    @Test
    void happyFlow() {
        final DefaultProduct product = new DefaultProduct(1, "testName", 2.4, Category.DRINK);
        assertThat(product).isNotNull();
        assertThat(product.getId()).isEqualTo(1);
        assertThat(product.getName()).isEqualTo("testName");
        assertThat(product.getPrice()).isEqualTo(2.4);
        assertThat(product.getCategory()).isEqualTo(Category.DRINK);
    }

}

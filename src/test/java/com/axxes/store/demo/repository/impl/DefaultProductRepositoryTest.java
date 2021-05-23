package com.axxes.store.demo.repository.impl;

import com.axxes.store.demo.domain.Category;
import com.axxes.store.demo.domain.Product;
import com.axxes.store.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class DefaultProductRepositoryTest {

    private static final ProductRepository REPOSITORY = new DefaultProductRepository();

    @Test
    void getProducts_happyFlow() {
        final List<Product> products = REPOSITORY.getProducts();
        assertThat(products).isNotNull().isNotEmpty().hasSize(8);
    }

    @Test
    void getById_happyFlow() {
        final Product product = REPOSITORY.getById(1);
        assertThat(product).isNotNull();
        assertThat(product.getId()).isEqualTo(1);
    }

    @Test
    void getById_idDoesNotExist() {
        assertThatExceptionOfType(ArrayIndexOutOfBoundsException.class).isThrownBy(() -> REPOSITORY.getById(18));
    }

    @Test
    void find_happyFlow() {
        final List<Product> products = REPOSITORY.find(product -> product.getCategory() == Category.FOOD);
        assertThat(products).isNotNull().isNotEmpty().hasSize(2);
    }

    @Test
    void findByCategory_happyFlow() {
        final List<Product> products = REPOSITORY.findByCategory(Category.DRINK);
        assertThat(products).isNotNull().isNotEmpty().hasSize(2);
    }

    @Test
    void findByName_happyFlow() {
        final List<Product> products = REPOSITORY.findByName("Leffe");
        assertThat(products).isNotNull().isNotEmpty().hasSize(1);
    }

    @Test
    void findByName_lowercase() {
        final List<Product> products = REPOSITORY.findByName("leffe");
        assertThat(products).isNotNull().isNotEmpty().hasSize(1);
    }
}

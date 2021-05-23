package com.axxes.store.demo.service.impl;

import com.axxes.store.demo.domain.Category;
import com.axxes.store.demo.domain.Product;
import com.axxes.store.demo.repository.ProductRepository;
import com.axxes.store.demo.service.CatalogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DefaultCatalogServiceTest {

    private ProductRepository repository;
    private CatalogService service;

    @BeforeEach
    void setup() {
        repository = mock(ProductRepository.class);
        service = new DefaultCatalogService(repository);
    }

    @Test
    void getAll() {
        final Product mock = mock(Product.class);
        when(repository.getProducts()).thenReturn(List.of(mock));

        assertThat(service.getAll()).isNotNull().isNotEmpty().hasSize(1).containsExactly(mock);
        verify(repository, times(1)).getProducts();
        verifyNoMoreInteractions(repository);
    }

    @Test
    void getById() {
        final Product mock = mock(Product.class);
        when(repository.getById(1)).thenReturn(mock);

        assertThat(service.getById("1")).isNotNull().isEqualTo(mock);
        verify(repository, times(1)).getById(1);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void getById_notAnInt() {
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> service.getById("One"));
        verifyNoInteractions(repository);
    }

    @Test
    void searchByCategory() {
        final Product mock = mock(Product.class);
        when(repository.findByCategory(any(Category.class))).thenReturn(List.of(mock));

        assertThat(service.searchByCategory(Category.FOOD)).isNotNull().isNotEmpty().hasSize(1).containsExactly(mock);
        verify(repository, times(1)).findByCategory(Category.FOOD);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void searchByName() {
        final Product mock = mock(Product.class);
        when(repository.findByName(any(String.class))).thenReturn(List.of(mock));

        assertThat(service.searchByName("mockName")).isNotNull().isNotEmpty().hasSize(1).containsExactly(mock);
        verify(repository, times(1)).findByName("mockName");
        verifyNoMoreInteractions(repository);
    }
}

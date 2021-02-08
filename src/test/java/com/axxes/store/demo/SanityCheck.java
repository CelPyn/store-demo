package com.axxes.store.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SanityCheck {

    @Test
    void dont_panic() {
        assertThat(42).isEqualTo(42);
    }
}

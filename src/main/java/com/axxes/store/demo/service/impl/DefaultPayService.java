package com.axxes.store.demo.service.impl;

import com.axxes.store.demo.domain.Basket;
import com.axxes.store.demo.service.PayService;

public class DefaultPayService implements PayService {

    @Override
    public double getTotal(final Basket basket) {
        throw new RuntimeException();
    }
}

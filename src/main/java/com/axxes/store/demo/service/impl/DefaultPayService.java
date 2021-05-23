package com.axxes.store.demo.service.impl;

import com.axxes.store.demo.domain.Basket;
import com.axxes.store.demo.domain.BasketItem;
import com.axxes.store.demo.service.PayService;

import java.util.List;

public class DefaultPayService implements PayService {

    @Override
    public double getTotal(final Basket basket) {
        final List<BasketItem> content = basket.getContent();
        return content.stream().mapToDouble(BasketItem::getSubtotal).sum();
    }
}

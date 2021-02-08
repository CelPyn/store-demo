package com.axxes.store.demo.domain;

import java.util.List;

public interface Basket {

    List<BasketItem> getContent();

    double getTotal();

}

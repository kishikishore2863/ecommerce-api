package com.kishi.ecommerce_api.service;

import com.kishi.ecommerce_api.exception.ProductException;
import com.kishi.ecommerce_api.model.User;
import com.kishi.ecommerce_api.request.AddItemRequest;

public interface CartService {

    public com.kishi.ecommerce_api.model.Cart createCart(User user);

    public String addCartItem(Long userId, AddItemRequest req)throws ProductException;

    public com.kishi.ecommerce_api.model.Cart findUserCart(Long userId);
}

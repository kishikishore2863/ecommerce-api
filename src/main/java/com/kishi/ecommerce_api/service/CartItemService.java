package com.kishi.ecommerce_api.service;

import com.kishi.ecommerce_api.exception.CartItemException;
import com.kishi.ecommerce_api.exception.UserException;
import com.kishi.ecommerce_api.model.Cart;
import com.kishi.ecommerce_api.model.CartItem;
import com.kishi.ecommerce_api.model.Product;

public interface CartItemService {

    public CartItem createCartItem(CartItem cartItem);

    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException;

    public CartItem isCartItemExist(Cart cart, Product product,String size,Long userId);

    public void  removeCartItem(Long userId,Long cartItemId)throws CartItemException,UserException;

    public CartItem findCartItemById(Long cartItemId)throws CartItemException;
}

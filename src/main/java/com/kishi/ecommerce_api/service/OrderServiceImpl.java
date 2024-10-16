package com.kishi.ecommerce_api.service;


import com.kishi.ecommerce_api.exception.OrderException;
import com.kishi.ecommerce_api.model.Address;
import com.kishi.ecommerce_api.model.Order;
import com.kishi.ecommerce_api.model.Product;
import com.kishi.ecommerce_api.model.User;
import com.kishi.ecommerce_api.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private CartRepository cartRepository;
    private CartItemService cartItemService;
    private ProductService  productService;

    public OrderServiceImpl(CartRepository cartRepository, CartItemService cartItemService, ProductService  productService){
        this.cartRepository=cartRepository;
        this.cartItemService=cartItemService;
        this.productService=productService;
    }


    @Override
    public Order createOrder(User user, Address shippingAddress) {

        return null;
    }

    @Override
    public Order findOrderById(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public List<Order> usersOrderHistory(Long userId) {
        return null;
    }

    @Override
    public Order placedOrder(Long oderId) throws OrderException {
        return null;
    }

    @Override
    public Order confrimedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order shippedOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order deliveredOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public Order canceledOrder(Long orderId) throws OrderException {
        return null;
    }

    @Override
    public List<Order> getAllOrder() {
        return null;
    }

    @Override
    public void deleteOrder(Long orderId) throws OrderException {

    }
}

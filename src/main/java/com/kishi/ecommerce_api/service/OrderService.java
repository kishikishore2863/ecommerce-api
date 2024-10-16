package com.kishi.ecommerce_api.service;

import com.kishi.ecommerce_api.exception.OrderException;
import com.kishi.ecommerce_api.model.Address;
import com.kishi.ecommerce_api.model.Order;
import com.kishi.ecommerce_api.model.User;

import java.util.List;


public interface OrderService  {

    public Order createOrder(User user, Address shippingAddress);

    public Order findOrderById(Long orderId)throws OrderException;

    public List<Order>usersOrderHistory(Long userId);

    public Order placedOrder(Long oderId)throws OrderException;

    public  Order confrimedOrder(Long orderId)throws OrderException;

    public Order shippedOrder(Long orderId)throws OrderException;

    public  Order deliveredOrder(Long orderId)throws OrderException;

    public Order canceledOrder(Long orderId)throws OrderException;

    public List<Order> getAllOrder();

    public void deleteOrder(Long orderId)throws OrderException;
}

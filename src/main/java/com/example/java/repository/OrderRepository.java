package com.example.java.repository;

import com.example.java.Models.Order;

import java.util.List;

public interface OrderRepository {
    Order read(Integer orderId);
    List<Order> readAll();
    void create(Order order);
    void update(Order order,Integer orderId);
    void delete(Integer orderId);
}

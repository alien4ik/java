package com.example.java.Controllers;

import com.example.java.DB;
import com.example.java.Models.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @GetMapping
    public ArrayList<Order> getClients() {
        return DB.getOrders();
    }

    @GetMapping("/{orderId}")
    public Order getClient(@PathVariable int orderId) {
        return DB.getOrder(orderId);
    }
}

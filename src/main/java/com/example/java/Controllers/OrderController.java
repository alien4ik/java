package com.example.java.Controllers;

import com.example.java.DB;
import com.example.java.Models.Client;
import com.example.java.Models.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @GetMapping
    public ArrayList<Order> getOrders() {
        return DB.getOrders();
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable int orderId) {
        return DB.getOrder(orderId);
    }
    @PostMapping
    public Order createOrder(@RequestBody Order order){
        return DB.createOrder(order);
    }
    @PutMapping("/{orderId}")
    public static void updateOrder(@RequestBody Order order, @PathVariable int orderId) {
        DB.updateOrder(order, orderId);
    }
    @DeleteMapping("/{orderId}")
    public static void deleteOrder(@PathVariable int orderId) {
        DB.deleteOrder(orderId);
    }
}

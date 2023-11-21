package com.example.java.Controllers;
import com.example.java.Models.Order;
import com.example.java.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<Order> getOrders(){
        return orderRepository.readAll();
    }
    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable("orderId") Integer orderId) {
        return orderRepository.read(orderId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void  create (@RequestBody Order order){
        orderRepository.create(order);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{orderId}")
    public  void updateClient(@RequestBody Order order, @PathVariable("orderId") Integer orderId) {
        orderRepository.update(order, orderId);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{orderId}")
    public void deleteClient(@PathVariable("orderId") Integer orderId) {
        orderRepository.delete(orderId);
    }
}

package com.example.java;

import com.example.java.Models.Client;
import com.example.java.Models.Order;

import java.util.ArrayList;
import java.util.Calendar;

public class DB {
    static ArrayList<Client> clients=new ArrayList<>();
    static ArrayList<Order> orders=new ArrayList<>();

    static {
        Client client1 = new Client(1, "user1@gmail.com", "Кузнецов", "14.03.2003", true);
        clients.add(client1);
        Client client2 = new Client(2, "user2@yandex.ru", "Хорошилов", "28.11.2003", true);
        clients.add(client2);
        Order order1 = new Order(1, 1, 300, Calendar.getInstance().getTime());
        orders.add(order1);
        Order order2 = new Order(2, 2, 500, Calendar.getInstance().getTime());
        orders.add(order2);
    }

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }
    public static Client getClient(int ClientId) {
        return clients
                .stream()
                .filter(x -> x.ClientId() == ClientId)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Client not Found"));
    }
    public static Order getOrder(int OrderId) {
        return orders
                .stream()
                .filter(x -> x.OrderId() == OrderId)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Order not Found"));
    }
}

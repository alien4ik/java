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
        Order order1 = new Order(1, 1, 300.004f, Calendar.getInstance().getTime());
        orders.add(order1);
        Order order2 = new Order(2, 2, 500f, Calendar.getInstance().getTime());
        orders.add(order2);
    }

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }
    public static Client getClient(int clientId) {
        return clients
                .stream()
                .filter(x -> x.clientId() == clientId)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Client not Found"));
    }
    public static Order getOrder(int orderId) {
        return orders
                .stream()
                .filter(x -> x.orderId() == orderId)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Order not Found"));
    }
    public static Client createClient(Client client){
        clients.add(client);
        return client;
    }
    public static void updateClient(Client client, int clientId) {
        var exist = getClient(clientId);
        clients.remove(exist);
        clients.add(client);
    }
    public static void deleteClient(int clientId) {
        var exist = getClient(clientId);
        clients.remove(exist);
    }
    public static Order createOrder(Order order){
        orders.add(order);
        return order;
    }
    public static void updateOrder(Order order, int orderId) {
        var exist = getOrder(orderId);
        orders.remove(exist);
        orders.add(order);
    }
    public static void deleteOrder(int orderId) {
        var exist = getOrder(orderId);
        orders.remove(exist);
    }
}

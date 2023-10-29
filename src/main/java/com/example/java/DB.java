package com.example.java;

import com.example.java.Models.Client;
import com.example.java.Models.Order;

import java.util.ArrayList;
import java.util.Calendar;

public class DB {
    static ArrayList<Client> clients=new ArrayList<>();
    static ArrayList<Order> orders=new ArrayList<>();
    public static ArrayList<Client> getClients(){
        Client client1=new Client(1,"user1@gmail.com","Кузнецов", "14.03.2003",true);
        clients.add(client1);
        Client client2=new Client(2,"user2@yandex.ru","Хорошилов", "28.11.2003",true);
        clients.add(client2);
        return clients;
    }
    public static ArrayList<Order> getOrders(){
        Order order1=new Order(1,1,300, Calendar.getInstance().getTime());
        orders.add(order1);
        Order order2=new Order(2,2,500, Calendar.getInstance().getTime());
        orders.add(order2);
        return orders;
    }
}

package com.example.java.repository;

import com.example.java.Models.Client;

import java.util.List;

public interface ClientRepository {
    Client read(Integer id);
    List<Client> readAll();
    void create(Client client);
    void update(Client client,Integer clientId);
    void delete(Integer clientId);
}

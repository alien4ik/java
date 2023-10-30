package com.example.java.Controllers;

import com.example.java.DB;
import com.example.java.Models.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @GetMapping
    public ArrayList<Client> getClients(){
        return DB.getClients();
    }
    @GetMapping("/{clientId}")
    public Client getClient(@PathVariable int clientId) {
        return DB.getClient(clientId);
    }
}

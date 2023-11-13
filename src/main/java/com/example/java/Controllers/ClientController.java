package com.example.java.Controllers;

import com.example.java.DB;
import com.example.java.Models.Client;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client){
        return DB.createClient(client);
    }
    @PutMapping("/{clientId}")
    public static void updateClient(@RequestBody Client client, @PathVariable int clientId) {
        DB.updateClient(client, clientId);
    }
    @DeleteMapping("/{clientId}")
    public static void deleteClient(@PathVariable int clientId) {
        DB.deleteClient(clientId);
    }
}

package com.example.java.Controllers;

import com.example.java.DB;
import com.example.java.Models.Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ClientController {
    @RequestMapping("/clients")
    public ArrayList<Client> getClients(){
        return DB.getClients();
    }
}

package com.example.java.Controllers;
import com.example.java.Models.Client;
import com.example.java.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<Client> getClients(){
        return clientRepository.readAll();
    }
    @GetMapping("/{clientId}")
    public Client getClient(@PathVariable("clientId") Integer clientId) {
        return clientRepository.read(clientId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void  create (@RequestBody Client client){
        clientRepository.create(client);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{clientId}")
    public  void updateClient(@RequestBody Client client, @PathVariable("clientId") Integer clientId) {
        clientRepository.update(client, clientId);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{clientId}")
    public void deleteClient(@PathVariable("clientId") int clientId) {
        clientRepository.delete(clientId);
    }
}

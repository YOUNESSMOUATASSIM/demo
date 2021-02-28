package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/Clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Client>> selectionnerClients(){
        List<Client> clientList=clientService.selectionnerClients();
        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> selectionnerClient(@PathVariable("id") Long id){
        Client client =clientService.selectionnerClient(id);
        return new ResponseEntity<>(client,HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Client> ajouterClient(@RequestBody Client client){
        Client client1=clientService.ajouterClient(client);
        return new ResponseEntity<>(client1,HttpStatus.CREATED);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<Client> modifierClient(@PathVariable("id") Long id,@RequestBody Client client){

        return ResponseEntity.ok(clientService.modifierClient(id,client));
    }
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Client> supprimerClient(@PathVariable("id") Long id){
        clientService.supprimerClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

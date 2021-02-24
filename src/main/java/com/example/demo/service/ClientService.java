package com.example.demo.service;

import com.projetStage.projetStage.exceptions.ClientException;
import com.example.demo.model.Client;
import com.example.demo.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientService {
    private final ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public Client ajouterClient(Client client){
        return clientRepository.save(client);
    }
    public Client modifierClient(Client client){
        return clientRepository.save(client);

    }
    public  void supprimerClient(Long idClient){
        clientRepository.deleteById(idClient);
    }
    public List<Client> selectionnerClients(){
        return clientRepository.findAll();
    }
    public Client selectionnerClient(Long idClient){
        return clientRepository.findById(idClient).
                orElseThrow(()->new ClientException("le client id :"+idClient+" n'existe pas !"));
    }

}

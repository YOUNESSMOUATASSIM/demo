package com.example.demo.service;

import com.projetStage.projetStage.exceptions.CommandeException;
import com.example.demo.model.Commande;
import com.example.demo.repo.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {
    private final CommandeRepository commandeRepository;
    @Autowired
    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }
    public Commande ajouterCommande(Commande commande){
       return commandeRepository.save(commande);
    }
    public Commande modifierCommande(Commande commande){
        return commandeRepository.save(commande);

    }
    public  void supprimerCommande(Long idCommande){
        commandeRepository.deleteById(idCommande);
    }
    public List<Commande> selectionnerCommandes(){
        return commandeRepository.findAll();
    }
    public Commande selectionnerCommande(Long idCommande){

        return commandeRepository.findById(idCommande).
                orElseThrow(()->new CommandeException("la commande id :"+idCommande+" n'existe pas !"));
    }

    public Commande modifierCommande(Long id, Commande commande) {
        Commande oldCommande=commandeRepository.getOne(id);

        oldCommande.setDateCommande(commande.getDateCommande());
        oldCommande.setLignesCommandeList(commande.getLignesCommandeList());
        oldCommande.setClient(commande.getClient());
        oldCommande.setPrix(commande.getPrix());
        oldCommande.setQuantite(commande.getQuantite());
        oldCommande.setResponsable(commande.getResponsable());


        return commandeRepository.save(oldCommande);
    }
}

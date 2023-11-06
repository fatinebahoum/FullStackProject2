package com.example.fullstack.modele;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class VoitureController {
    @Autowired //permet d'injecter une instance de VoitureRepo dans le contrôleur. Cela signifie que le contrôleur peut utiliser voitureRepo pour accéder aux données des voitures.
    private VoitureRepo voitureRepo;

    @CrossOrigin(origins = "http://localhost:3000") //autorise les requêtes provenant de l'origine spécifiée (dans ce cas, "http://localhost:3000").
    @RequestMapping("/voitures") //Lorsqu'une requête est faite vers cette URL, la méthode getVoitures sera exécutée.
    public Iterable<Voiture> getVoitures(){
        return voitureRepo.findAll();
    }


}


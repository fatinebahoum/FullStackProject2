package com.example.fullstack.modele;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietaireRepo extends CrudRepository<Proprietaire, Long> {
    //Définit l'interface ProprietaireRepo, qui étend CrudRepository. Cette interface est générique et paramétrée avec deux types : le type de l'entité (Proprietaire) qu'on souhaite gérer et le type de la clé primaire de cette entité
}

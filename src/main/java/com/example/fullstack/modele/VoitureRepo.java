package com.example.fullstack.modele;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@RepositoryRestResource //déclarer cette interface comme un "resource repository" Spring Data REST.
public interface VoitureRepo extends CrudRepository<Voiture,Long>{ //Définit l'interface VoitureRepo, qui étend CrudRepository. Cette interface est générique et paramétrée avec deux types : le type de l'entité (Voiture) qu'on souhaite gérer et le type de la clé primaire de cette entité
    List<Voiture> findByModele(@Param("modele") String modele);
    List<Voiture> findByCouleur(@Param("couleur") String couleur);
}

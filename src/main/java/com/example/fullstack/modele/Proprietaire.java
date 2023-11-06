package com.example.fullstack.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity //indique à JPA que la classe Proprietaire est une entité persistante.
@RequiredArgsConstructor //génère un constructeur qui prend en compte tous les champs marqués avec @NonNull.
@NoArgsConstructor //génère un constructeur sans argument.
@Data //génère automatiquement les méthodes equals, hashCode, toString, et les méthodes getter/setter pour tous les champs de la classe.
public class Proprietaire {

    @Id //indique que le champ id est la clé primaire de l'entité.
    @GeneratedValue(strategy= GenerationType.AUTO) //spécifie comment la clé primaire id doit être générée automatiquement. Ici, GenerationType.AUTO signifie que la génération dépend de la configuration de la base de données.

    private long id;
    @NonNull
    private String nom;
    @NonNull
    private String prenom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="proprietaire") //indique qu'il s'agit d'une relation One-to-Many entre la classe Proprietaire et la classe Voiture.
    // CascadeType.ALL, ce qui signifie que les opérations de création, mise à jour et suppression effectuées sur un Proprietaire se propageront aux Voiture associées.
    @JsonIgnore //indique que la sérialisation de la relation voitures ne sera pas incluse lors de la conversion de l'objet Proprietaire en JSON,
    private List<Voiture> voitures;
}

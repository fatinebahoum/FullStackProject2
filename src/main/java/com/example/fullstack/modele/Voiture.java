package com.example.fullstack.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity //indique à JPA que la classe Voiture est une entité persistante, ce qui signifie qu'elle peut être stockée dans une base de données relationnelle.
@Data //Cette annotation de Lombok génère automatiquement les méthodes equals, hashCode, toString, et les méthodes getter/setter pour tous les champs de la classe
@RequiredArgsConstructor //Cette annotation de Lombok génère un constructeur qui prend en compte tous les champs marqués avec @NonNull.
@NoArgsConstructor //Cette annotation de Lombok génère un constructeur sans argument
public class Voiture {
    @Id //Cette annotation est utilisée pour spécifier que le champ id est la clé primaire de l'entité
    @GeneratedValue(strategy= GenerationType.AUTO) //Cette annotation est utilisée pour spécifier comment la clé primaire id doit être générée automatiquement.
    private long id;
    @NonNull
    private String marque;
    @NonNull
    private String modele;
    @NonNull
    private String couleur;
    @NonNull
    private String immatricule;
    @NonNull
    private int annee;
    @NonNull
    private int prix;
    @ManyToOne(fetch = FetchType.EAGER) // Définit une relation Many-to-One avec la classe Proprietaire,  La relation est chargée de manière "EAGER," ce qui signifie que lorsqu'on charge une instance de Voiture, la relation proprietaire est également chargée immédiatement.
    @JsonIgnore // Indique à Jackson d'ignorer la sérialisation de la relation proprietaire. C-a-d; la relation proprietaire ne sera pas incluse lors de la conversion de l'objet de type Voiture en format JSON.
    @JoinColumn(name = "proprietaire") // Cette annotation spécifie le nom de la colonne dans la table Voiture qui est utilisée pour stocker la clé étrangère vers la table Proprietaire.
    @NonNull
    private Proprietaire proprietaire;
}

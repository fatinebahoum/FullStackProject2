package com.example.fullstack.modele;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class VoitureDeserializer extends JsonDeserializer<Voiture> {
    @Override
    public Voiture deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String marque = node.get("marque").asText();
        String modele = node.get("modele").asText();
        String couleur = node.get("couleur").asText();
        String immatricule = node.get("immatricule").asText();
        int annee = node.get("annee").asInt();
        int prix = node.get("prix").asInt();

        JsonNode proprietaireNode = node.get("proprietaire");
        String nom = proprietaireNode.get("nom").asText();
        String prenom = proprietaireNode.get("prenom").asText();

        Proprietaire proprietaire = new Proprietaire(nom, prenom);

        return new Voiture(marque, modele, couleur, immatricule, annee, prix, proprietaire);
    }
}

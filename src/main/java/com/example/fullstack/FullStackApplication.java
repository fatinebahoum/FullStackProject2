package com.example.fullstack;

import com.example.fullstack.modele.Proprietaire;
import com.example.fullstack.modele.ProprietaireRepo;
import com.example.fullstack.modele.VoitureRepo;
import com.example.fullstack.modele.Voiture;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@SpringBootApplication
public class FullStackApplication {
    @Autowired
    private VoitureRepo repository;

    public static void main(String[] args) {

        SpringApplication.run(FullStackApplication.class, args);
    }
    @Autowired
    ProprietaireRepo proprietaireRepo;

    @Bean
    CommandLineRunner runner(){
        return args -> {
            Proprietaire proprietaire1 = new Proprietaire("Ali" , "Hassan");
            Proprietaire proprietaire2 = new Proprietaire("Najat" , "Bani");
            proprietaireRepo.save(proprietaire1);
            proprietaireRepo.save(proprietaire2);

            repository.save(new Voiture("Toyota", "Corolla", "Grise", "A-1-9090", 2018, 95000,
                    proprietaire1));
            repository.save(new Voiture("Ford", "Fiesta", "Rouge", "A-2-8090", 2015, 90000,
                    proprietaire1));
            repository.save(new Voiture("Honda", "CRV", "Bleu", "A-3-7090", 2016, 140000,
                    proprietaire2));
        };

    }


    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}

package com.example.client.service;

import com.example.client.model.Voiture;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class VoitureClientWeb {
    private final WebClient client;

    public VoitureClientWeb(WebClient.Builder builder) {
        this.client = builder.build();
    }

    public Voiture getVoitureByClientId(Long clientId) {
        return client.get()
                .uri("http://SERVICE-VOITURE/api/cars/byClient/{id}", clientId)
                .retrieve()
                .bodyToMono(Voiture.class)
                .block();
    }
}

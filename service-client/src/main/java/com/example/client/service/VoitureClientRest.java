package com.example.client.service;

import com.example.client.model.Voiture;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VoitureClientRest {
    private final RestTemplate restTemplate;

    public VoitureClientRest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Voiture getVoitureByClientId(Long clientId) {
        return restTemplate.getForObject("http://SERVICE-VOITURE/api/cars/byClient/" + clientId, Voiture.class);
    }
}

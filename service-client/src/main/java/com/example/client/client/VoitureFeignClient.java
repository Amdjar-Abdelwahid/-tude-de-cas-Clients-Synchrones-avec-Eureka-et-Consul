package com.example.client.client;

import com.example.client.model.Voiture;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SERVICE-VOITURE")
public interface VoitureFeignClient {
    @GetMapping("/api/cars/byClient/{clientId}")
    Voiture getVoitureByClientId(@PathVariable("clientId") Long clientId);
}

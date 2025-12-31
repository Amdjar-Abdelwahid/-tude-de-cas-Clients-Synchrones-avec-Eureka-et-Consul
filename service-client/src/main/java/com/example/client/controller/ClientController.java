package com.example.client.controller;

import com.example.client.client.VoitureFeignClient;
import com.example.client.model.Voiture;
import com.example.client.service.VoitureClientRest;
import com.example.client.service.VoitureClientWeb;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final VoitureClientRest restClient;
    private final VoitureFeignClient feignClient;
    private final VoitureClientWeb webClient;

    public ClientController(VoitureClientRest restClient, VoitureFeignClient feignClient, VoitureClientWeb webClient) {
        this.restClient = restClient;
        this.feignClient = feignClient;
        this.webClient = webClient;
    }

    @GetMapping("/{id}/car/rest")
    public Voiture getCarWithRestTemplate(@PathVariable Long id) {
        return restClient.getVoitureByClientId(id);
    }

    @GetMapping("/{id}/car/feign")
    public Voiture getCarWithFeign(@PathVariable Long id) {
        return feignClient.getVoitureByClientId(id);
    }

    @GetMapping("/{id}/car/webclient")
    public Voiture getCarWithWebClient(@PathVariable Long id) {
        return webClient.getVoitureByClientId(id);
    }
}

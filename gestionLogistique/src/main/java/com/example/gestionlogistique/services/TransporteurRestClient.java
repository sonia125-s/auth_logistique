package com.example.gestionlogistique.services;

import com.example.gestionlogistique.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "users-service",url="${application.config.users-url}")
public interface TransporteurRestClient {
    @GetMapping(path="/{id}")
    User findTransporteurById(@PathVariable Long id);
}

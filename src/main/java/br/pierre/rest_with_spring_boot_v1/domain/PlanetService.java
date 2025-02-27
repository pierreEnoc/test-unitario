package br.pierre.rest_with_spring_boot_v1.domain;


import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanetService {
    private PlanetRepository PlanetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.PlanetRepository = planetRepository;
    }

    public Planet create(Planet planet) {
        return PlanetRepository.save(planet);
    }

    public Optional<Planet> get(Long id) {
        return PlanetRepository.findById(id);
    }
}

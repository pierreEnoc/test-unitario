package br.pierre.rest_with_spring_boot_v1.domain;


import org.springframework.stereotype.Service;

@Service
public class PlanetService {
    private PlanetRepository PlanetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.PlanetRepository = planetRepository;
    }

    public Planet create(Planet planet) {
        return PlanetRepository.save(planet);
    }
}

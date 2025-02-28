package br.pierre.rest_with_spring_boot_v1.domain;


import org.hibernate.boot.model.internal.QueryBinder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Example;


import javax.management.Query;
import java.util.List;
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

    public Optional<Planet> getByName(String name) {
        return PlanetRepository.findByName(name);
    }

    public List<Planet> list(String terrain, String climate) {
        Example<Planet> query = QueryBuilder.makeQuery(new Planet(climate, terrain));
        return PlanetRepository.findAll(query);
    }

}

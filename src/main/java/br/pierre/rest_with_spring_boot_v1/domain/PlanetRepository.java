package br.pierre.rest_with_spring_boot_v1.domain;

import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlanetRepository extends CrudRepository<Planet, Long> {
 Optional<Planet> findByName(String name);
}

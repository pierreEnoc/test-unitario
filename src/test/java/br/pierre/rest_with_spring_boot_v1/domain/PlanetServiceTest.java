package br.pierre.rest_with_spring_boot_v1.domain;

import org.hibernate.annotations.NotFound;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static br.pierre.rest_with_spring_boot_v1.common.PlanetConstants.INVALID_PLANET;
import static br.pierre.rest_with_spring_boot_v1.common.PlanetConstants.PLANET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.optional;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlanetServiceTest {

    @InjectMocks
    private PlanetService planetService;

   @Mock
    private PlanetRepository planetRepository;

    //operacao_estado_returno
    @Test
    public void creatPlanet_WithValidData_returnsPlanet() {

     when(planetRepository.save(PLANET)).thenReturn(PLANET);

     Planet sut =  planetService.create(PLANET);
     assertThat(sut).isEqualTo(PLANET);

    }

    @Test
    public void createPlanet_whithInvalidData_ThowsException() {
        planetService.create(INVALID_PLANET);
    }

    @Test
    public void getPlanet_ByExistingId_ReturnPlanet() {
        when(planetRepository.findById(1L)).thenReturn(Optional.of(PLANET));

        Optional<Planet> sut = planetService.get(1L);

        assertThat(sut).isNotEmpty();
        assertThat(sut.get()).isEqualTo(PLANET);
    }

    @Test
    public void getPlanet_byUnexistingId_ReturnsEmpty() {
        when(planetRepository.findById(anyLong())).thenReturn(Optional.empty());

        Optional<Planet> sut = planetService.get(1L);

        assertThat(sut).isEmpty();
    }


}

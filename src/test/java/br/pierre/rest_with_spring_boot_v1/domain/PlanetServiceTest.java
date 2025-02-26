package br.pierre.rest_with_spring_boot_v1.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static br.pierre.rest_with_spring_boot_v1.common.PlanetConstants.PLANET;
import static org.assertj.core.api.Assertions.assertThat;
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
}

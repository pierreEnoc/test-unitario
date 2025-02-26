package br.pierre.rest_with_spring_boot_v1.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static br.pierre.rest_with_spring_boot_v1.common.PlanetConstants.PLANET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = PlanetService.class)
public class PlanetServiceTest {

    @Autowired
    private PlanetService planetService;

    @MockitoBean
    private PlanetRepository planetRepository;

    //operacao_estado_returno
    @Test
    public void creatPlanet_WithValidData_returnsPlanet() {
        //AAA
        //Arange
     when(planetRepository.save(PLANET)).thenReturn(PLANET);

     //System under test
        //Act(agir fazer a operacao que agente quer testar)
     Planet sut =  planetService.create(PLANET);
   //Assert
     assertThat(sut).isEqualTo(PLANET);

    }
}

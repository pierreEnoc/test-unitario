package br.pierre.rest_with_spring_boot_v1.common;

import br.pierre.rest_with_spring_boot_v1.domain.Planet;

public class PlanetConstants {
    public static final Planet PLANET = new Planet("name","climate", "terrain");
    public static final Planet INVALID_PLANET = new Planet(" "," ", " ");
}

package com.example.DisneyAPI.dtos;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonajeDtoWithPeliculas extends PersonajeDto {
    
    private Set<PeliculaDto> peliculas;
}

package com.example.DisneyAPI.dtos;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeliculaDtoWithPersonajes extends PeliculaDto{
    private Set<PersonajeDto> personajes;
}

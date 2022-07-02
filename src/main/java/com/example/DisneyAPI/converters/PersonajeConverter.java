package com.example.DisneyAPI.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.DisneyAPI.dtos.PersonajeDto;
import com.example.DisneyAPI.models.Personaje;

@Component
public class PersonajeConverter {
    
    public PersonajeDto entityToDto(Personaje entity){

        PersonajeDto dto = new PersonajeDto();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        dto.setEdad(entity.getEdad());
        dto.setPeso(entity.getPeso());
        Set<Long> idsPeliculas = new HashSet<>();
        entity.getPeliculas().forEach(pelicula -> idsPeliculas.add(pelicula.getId()));
        dto.setIdsPeliculas(idsPeliculas);
        return dto;

    }



    

}

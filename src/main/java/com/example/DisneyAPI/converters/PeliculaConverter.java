package com.example.DisneyAPI.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.DisneyAPI.dtos.PeliculaDto;
import com.example.DisneyAPI.dtos.PeliculaDtoWithPersonajes;
import com.example.DisneyAPI.models.Pelicula;

@Component
public class PeliculaConverter {
    
    public PeliculaDto entityToDto(Pelicula entity){
        PeliculaDto dto = new PeliculaDto();

        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setTitulo(entity.getTitulo());
        dto.setFecha(entity.getFecha());
        dto.setCalificacion(entity.getCalificacion());
        Set<Long> idsPersonajes = new HashSet<>();
        entity.getPersonajes().forEach(personaje -> idsPersonajes.add(personaje.getId()));
        dto.setIdsPersonajes(idsPersonajes);

        return dto;
    }

    public Pelicula dtoToEntity(PeliculaDto dto){
        // tu codigo

        return null;
    }

    public Pelicula dtoWithPersonajesToEntity(PeliculaDtoWithPersonajes dto){
        // tu codigo

        return null;
    }

    public PeliculaDtoWithPersonajes entityToDtoWithPersonajes(Pelicula entity){
        // tu codigo

        return null;
    }

    public void fill(Pelicula entity, PeliculaDto dto){
        if (dto.getTitulo() != null)
            entity.setTitulo(dto.getTitulo());
    }
}

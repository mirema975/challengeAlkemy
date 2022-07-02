package com.example.DisneyAPI.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DisneyAPI.converters.PeliculaConverter;
import com.example.DisneyAPI.dtos.PeliculaDto;
import com.example.DisneyAPI.models.Pelicula;
import com.example.DisneyAPI.repository.PeliculaRepository;

@Service
public class PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    PeliculaConverter peliculaConverter;

    public List<PeliculaDto> findAll(){
        List<Pelicula> entities = peliculaRepository.findAll();

        List<PeliculaDto> dtos = new ArrayList<>(entities.size());

        entities.forEach(entity -> dtos.add(peliculaConverter.entityToDto(entity)));

        return dtos;
        // return peliculaRepository.findAll().stream().map(peliculaConverter::entityToDto).toList();
    }

    public PeliculaDto findById(Long id){
        Optional<Pelicula> entityOptional = peliculaRepository.findById(id);

        if(entityOptional.isPresent()) return peliculaConverter.entityToDto(entityOptional.get());
        return null;
    }

    public List<PeliculaDto> findByTitulo(String titulo){
        List<Pelicula> entities = peliculaRepository.findByTitulo(titulo);

        List<PeliculaDto> dtos = new ArrayList<>(entities.size());

        entities.forEach(entity -> dtos.add(peliculaConverter.entityToDto(entity)));

        return dtos;
    }

    public List<PeliculaDto> ordenar(String orden){
        List<Pelicula> entities = peliculaRepository.findAll();
        
        List<PeliculaDto> dtos = new ArrayList<>(entities.size());

        entities.forEach(entity -> dtos.add(peliculaConverter.entityToDto(entity)));

        if(orden.equals("DESC")){
            Collections.sort(dtos, (o1, o2) -> o2.getTitulo().compareTo(o1.getTitulo()));
            return dtos;
        }else if (orden.equals("ASC")){
            Collections.sort(dtos, (o1, o2) -> o1.getTitulo().compareTo(o2.getTitulo()));
            return dtos;
        }
        return Collections.emptyList();
    }

    public PeliculaDto guardar(PeliculaDto dto) {
        peliculaRepository.save(peliculaConverter.dtoToEntity(dto));
        return dto;
    }

    public void eliminar(Long id){
        peliculaRepository.deleteById(id);
    }

    public PeliculaDto update(Long id, PeliculaDto dto) {
        Optional<Pelicula> entityOptional = peliculaRepository.findById(id);

        if(entityOptional.isPresent()){
            peliculaConverter.fill(entityOptional.get(), dto);
            return peliculaConverter.entityToDto(peliculaRepository.save(entityOptional.get()));
        }
        return null;
    }


}

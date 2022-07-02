package com.example.DisneyAPI.service;

import com.example.DisneyAPI.converters.PersonajeConverter;
import com.example.DisneyAPI.dtos.PersonajeDto;
import com.example.DisneyAPI.models.Personaje;
import com.example.DisneyAPI.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonajeService {

    @Autowired
    PersonajeRepository personajeRepository;

    @Autowired
    PersonajeConverter personajeConverter;

    public List<PersonajeDto> obtenerPersonajes() {
        List<Personaje> entities = personajeRepository.findAll();

        List<PersonajeDto> dtos = new ArrayList<>();

        entities.forEach(entity -> dtos.add(personajeConverter.entityToDto(entity)));

        return dtos;
    }

    public List<PersonajeDto> findByNombre(String nombre){
        List<Personaje> entities = personajeRepository.findByNombre(nombre);

        List<PersonajeDto> dtos = new ArrayList<>();

        entities.forEach(entity -> dtos.add(personajeConverter.entityToDto(entity)));

        return dtos;

    }

    public List<Personaje> obtenerPorEdad(int edad){
        List personajesFiltrados = new ArrayList<>();
        personajeRepository.findByEdad(edad).forEach(personaje -> 
        {
            List personajes = new ArrayList<>();
            personajes.add(personaje.getId());
            personajes.add(personaje.getImagen());
            personajes.add(personaje.getNombre());
        });
        return personajesFiltrados;
    }

    public List<Personaje> obtenerPorPeliculas(Long id){
        List personajesFiltrados = new ArrayList<>();
        personajeRepository.findAllByPeliculas_Id(id).forEach(personaje -> 
        {
            List personajes = new ArrayList<>();
            personajes.add(personaje.getId());
            personajes.add(personaje.getImagen());
            personajes.add(personaje.getNombre());
        });
        return personajesFiltrados;
    }

    public List<Personaje> obtenerPorPeso(double peso){
        List personajesFiltrados = new ArrayList<>();
        personajeRepository.findByPeso(peso).forEach(personaje -> 
        {
            List personajes = new ArrayList<>();
            personajes.add(personaje.getId());
            personajes.add(personaje.getImagen());
            personajes.add(personaje.getNombre());
        });
        return personajesFiltrados;
    }

    public Personaje guardarPersonaje(Personaje personaje) {
        return personajeRepository.save(personaje);
    }

    public Optional<Personaje> obtenerPorId(Long id){
        return personajeRepository.findById(id);
    }

    public boolean eliminarPersonaje(Long id){
        try {
            personajeRepository.deleteById(id);
            return true;
        } catch (Error error) {
            return false;
        }
    }

    public void actualizarPersonaje(Personaje personaje){
        personajeRepository.save(personaje);
    }


}

package com.example.DisneyAPI.service;

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


    public List<Personaje> obtenerPersonajes() {
        return (List<Personaje>) personajeRepository.findAll();
    }

    public List<Personaje> obtenerPorNombre(String nombre){
        List personajesFiltrados = new ArrayList<>();
        personajeRepository.findByNombre(nombre).forEach(personaje -> 
        {
            List personajes = new ArrayList<>();
            personajes.add(personaje.getId());
            personajes.add(personaje.getImagen());
            personajes.add(personaje.getNombre());
            personajesFiltrados.add(personajes);
        });
        return personajesFiltrados;
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

package com.example.DisneyAPI.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DisneyAPI.models.Pelicula;
import com.example.DisneyAPI.repository.PeliculaRepository;
import com.example.DisneyAPI.repository.PersonajeRepository;

@Service
public class PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    public List<Pelicula> obtenerPeliculas(){
        return peliculaRepository.findAll();
    }

    public Optional<Pelicula> obtenerPelicula(Long id){
        return peliculaRepository.findById(id);
    }

    public List<Pelicula> obtenerPorTitulo(String titulo){
        List peliculasFiltradas = new ArrayList<>();
        peliculaRepository.findByTitulo(titulo).forEach(p -> {
            List peliculas = new ArrayList<>();
            peliculas.add(p.getId());
            peliculas.add(p.getImagen());
            peliculas.add(p.getTitulo());
            peliculas.add(p.getFecha());
            peliculasFiltradas.add(peliculas);
        });
        return peliculasFiltradas;
    }

    public List<Pelicula> ordenarPeliculas(String orden){
        List<Pelicula> allPeliculas = peliculaRepository.findAll();
        List peliculasOrdenadas = new ArrayList<>();
        if(orden.equals("DESC")){
            Collections.sort(allPeliculas, (o1, o2) -> o2.getTitulo().compareTo(o1.getTitulo()));
            allPeliculas.forEach(pelicula -> {
                List peliculas = new ArrayList<>();
                peliculas.add(pelicula.getId());
                peliculas.add(pelicula.getImagen());
                peliculas.add(pelicula.getTitulo());
                peliculas.add(pelicula.getFecha());
                peliculasOrdenadas.add(peliculas);
            });
            return peliculasOrdenadas;
        }
        Collections.sort(allPeliculas, (o1, o2) -> o1.getTitulo().compareTo(o2.getTitulo()));
            allPeliculas.forEach(pelicula -> {
                List peliculas = new ArrayList<>();
                peliculas.add(pelicula.getId());
                peliculas.add(pelicula.getImagen());
                peliculas.add(pelicula.getTitulo());
                peliculas.add(pelicula.getFecha());
                peliculasOrdenadas.add(peliculas);
            });
            return peliculasOrdenadas;
    }

    public Pelicula guardarPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public void agregarPersonaje(Long id, Long idCharacter){
        
    }

    public void eliminarPelicula(Long id){
        peliculaRepository.deleteById(id);
    }


}

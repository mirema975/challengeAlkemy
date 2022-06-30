package com.example.DisneyAPI.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DisneyAPI.models.Pelicula;
import com.example.DisneyAPI.service.PeliculaService;

@RestController
@RequestMapping(value = "peliculas")
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> obtenerPeliculas(){
        return peliculaService.obtenerPeliculas();
    }

    @GetMapping(params = "id")
    public Optional<Pelicula> obtenerPelicula(@RequestParam Long id){
        return peliculaService.obtenerPelicula(id);
    }

    @GetMapping(params = "titulo")
    public List<Pelicula> obtenerPorTitulo(@RequestParam String titulo){
        return peliculaService.obtenerPorTitulo(titulo);
    }

    @GetMapping(params = "order")
    public List<Pelicula> ordenar(@RequestParam String order){
        return peliculaService.ordenarPeliculas(order);
    }

    @PostMapping
    public Pelicula guardarPelicula(@RequestBody Pelicula pelicula){
        return peliculaService.guardarPelicula(pelicula);
    }

    @DeleteMapping
    public void eliminarPelicula(@RequestParam Long id){
        peliculaService.eliminarPelicula(id);
    }


}

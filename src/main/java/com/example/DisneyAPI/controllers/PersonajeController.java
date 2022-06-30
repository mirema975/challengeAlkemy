package com.example.DisneyAPI.controllers;

import com.example.DisneyAPI.models.Personaje;
import com.example.DisneyAPI.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping (value = "characters")
public class PersonajeController {

    @Autowired
    PersonajeService personajeService;

    @GetMapping
    public List<Personaje> obtenerPersonajes(){
        return personajeService.obtenerPersonajes();
    }

    @GetMapping(params = "id")
    public Optional<Personaje> obtenerPersonaje(@RequestParam Long id){
        return personajeService.obtenerPorId(id);
    }

    @GetMapping(params = "name")
    public List<Personaje> obtenerPorNombre(@RequestParam String name){
        return personajeService.obtenerPorNombre(name);
    }

    @GetMapping(params = "age")
    public List<Personaje> obtenerPorEdad(@RequestParam int age){
        return personajeService.obtenerPorEdad(age);
    }

    @GetMapping(params = "peso")
    public List<Personaje> obtenerPorPeso(@RequestParam double peso){
        return personajeService.obtenerPorPeso(peso);
    }

    @GetMapping(params = "movies")
    public List<Personaje> obtenerPorPeliculas(@RequestParam Long movies){
        return personajeService.obtenerPorPeliculas(movies);
    }

    @PostMapping
    public Personaje crearPersonaje(@RequestBody Personaje personaje){
        return personajeService.guardarPersonaje(personaje); 
    }

    @PutMapping
    public Personaje actualizarPersonaje(@RequestBody Personaje personaje){
        personajeService.actualizarPersonaje(personaje);
        return personaje;
    }

    @DeleteMapping
    public String eliminarPersonaje(@RequestParam Long id){
        if(personajeService.eliminarPersonaje(id)){
            return "Se eliminó el Personaje";
        }
        return "No se elimino el personaje";
    }


}

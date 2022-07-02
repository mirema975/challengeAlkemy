package com.example.DisneyAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DisneyAPI.dtos.PeliculaDto;
import com.example.DisneyAPI.service.PeliculaService;

@RestController
@RequestMapping(value = "/peliculas")
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @GetMapping
    public ResponseEntity<List<PeliculaDto>> obtenerPeliculas(){
        return ResponseEntity.ok(peliculaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDto> obtenerPelicula(@PathVariable Long id){
        if (id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(peliculaService.findById(id), HttpStatus.OK);
    }

    @GetMapping(params = "titulo")
    public ResponseEntity<List<PeliculaDto>> obtenerPorTitulo(@RequestParam String titulo){
        return new ResponseEntity<>(peliculaService.findByTitulo(titulo), HttpStatus.OK);
    }

    @GetMapping(params = "order")
    public ResponseEntity<List<PeliculaDto>> ordenar(@RequestParam String order){
        return new ResponseEntity<>(peliculaService.ordenar(order), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PeliculaDto> guardar(@RequestBody PeliculaDto pelicula){
        return new ResponseEntity<>(peliculaService.guardar(pelicula), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDto> update(@PathVariable("id") Long id, @RequestBody PeliculaDto dto){
        PeliculaDto responseBody = peliculaService.update(id, dto);
        if (responseBody != null)
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping
    public void eliminar(@RequestParam Long id){
        peliculaService.eliminar(id);
    }

}

package com.example.DisneyAPI.repository;

import com.example.DisneyAPI.models.Pelicula;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    List<Pelicula> findByTitulo(String titulo);
}

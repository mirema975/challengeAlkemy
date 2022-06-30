package com.example.DisneyAPI.repository;

import com.example.DisneyAPI.models.Pelicula;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Serializable> {

    List<Pelicula> findByTitulo(String titulo);

    

}

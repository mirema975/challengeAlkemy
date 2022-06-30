package com.example.DisneyAPI.repository;

import com.example.DisneyAPI.models.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Serializable> {

    List<Personaje> findByNombre(String nombre);

    List<Personaje> findByEdad(int edad);

    List<Personaje> findByPeso(double peso);

    List<Personaje> findAllByPeliculas_Id(Long id);

}

package com.example.DisneyAPI.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "genero")
@Getter
@Setter
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;


    private String imagen;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Pelicula> peliculas;


}

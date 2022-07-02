package com.example.DisneyAPI.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="personaje")
@Getter
@Setter
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagen;

    @Column(nullable = false)
    private String nombre;

    private int edad;

    private double peso;

    private String historia;

    @ManyToMany(mappedBy = "personajes", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Pelicula> peliculas;

}

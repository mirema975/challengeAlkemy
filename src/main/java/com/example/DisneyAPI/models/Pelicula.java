package com.example.DisneyAPI.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Set;
import java.util.Date;

@Entity
@Table(name = "pelicula")
@Getter
@Setter
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imagen;

    private String titulo;

    private Date fecha;

    private int calificacion;

    @ManyToMany
    private Set<Personaje> personajes;

}

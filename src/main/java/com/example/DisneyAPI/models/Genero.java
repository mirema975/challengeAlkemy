package com.example.DisneyAPI.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name = "genero_id")
    private Long id;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String imagen;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnoreProperties (value = "generos")
    @Getter @Setter
    private Set<Pelicula> peliculas;

    public Genero() {
        super();
    }

}

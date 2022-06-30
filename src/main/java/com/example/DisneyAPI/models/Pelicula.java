package com.example.DisneyAPI.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.Date;

@Entity
@Table(name = "pelicula")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Getter @Setter
    private String imagen;

    @Getter @Setter
    private String titulo;

    @Getter @Setter
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date fecha;

    @Column(length = 5)
    @Getter @Setter
    private int calificacion;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = "peliculas")
    @Getter @Setter
    private Set<Personaje> personajes;

    public Pelicula() {
        super();
    }

}

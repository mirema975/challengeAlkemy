package com.example.DisneyAPI.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="personaje")
@ToString
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String imagen;

    @Column(nullable = false)
    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private int edad;

    @Getter @Setter
    private double peso;

    @Getter @Setter
    private String historia;

    @ManyToMany(mappedBy = "personajes", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = "personajes")
    @Getter @Setter
    private Set<Pelicula> peliculas;

    public Personaje() {
        super();
    }
    

}

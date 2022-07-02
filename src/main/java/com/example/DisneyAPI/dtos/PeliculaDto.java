package com.example.DisneyAPI.dtos;

import java.util.Date;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeliculaDto {

    private Long id;

    private String imagen;

    private String titulo;

    private Date fecha;

    private int calificacion;

    private Set<Long> idsPersonajes;

}

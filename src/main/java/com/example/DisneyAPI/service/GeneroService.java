package com.example.DisneyAPI.service;

import com.example.DisneyAPI.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GeneroService {

    @Autowired
    GeneroRepository generoRepository;

}

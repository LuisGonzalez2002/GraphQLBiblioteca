package com.example.demo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Objects;

@Controller
public class LibroController {

    private final LibroRepository libroRepository;

    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }
    @QueryMapping
    Iterable<Libro> libros(){
        return libroRepository.findAll();
    }

    @QueryMapping
    Libro libroById(@Argument("idlibro") Long idLibro){
        if (idLibro == null) {
            throw new IllegalArgumentException("Id must not be null");
        }
        return libroRepository.findById(idLibro).orElse(null);
    }

}

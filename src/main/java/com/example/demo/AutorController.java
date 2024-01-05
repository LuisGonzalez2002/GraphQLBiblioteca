package com.example.demo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }


    @QueryMapping
    Iterable<Autor> autores(){
        return autorRepository.findAll();
    }

    @QueryMapping
    Autor autorById(@Argument("idAutor") Long idAutor){
        if (idAutor == null) {
            throw new IllegalArgumentException("Id must not be null");
        }
        return autorRepository.findById(idAutor).orElse(null);
    }
}

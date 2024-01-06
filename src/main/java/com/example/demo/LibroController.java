package com.example.demo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;



@Controller
public class LibroController {

    private final LibroRepository libroRepository;

    private final AutorRepository autorRepository;

    public LibroController(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }


    @QueryMapping
    Iterable<Libro> libros(){
        return libroRepository.findAll();
    }

    @QueryMapping
    Libro libroByID(@Argument("idlibro") Long idLibro){
        if (idLibro == null) {
            throw new IllegalArgumentException("Id must not be null");
        }
        return libroRepository.findById(idLibro).orElse(null);
    }
    @MutationMapping
    Libro crearLibro(@Argument("titulo") String titulo, @Argument("idAutor") Long idAutor){
        Autor autor = autorRepository.findById(idAutor).orElse(null);
        if (autor == null) {
            throw new IllegalArgumentException("Author with given id not found");
        }
        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        return libroRepository.save(libro);
    }


}

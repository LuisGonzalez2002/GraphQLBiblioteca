package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Libro")
public class Libro {
    @Id
    @Column(name = "idlibro")
    private Long idLibro;
    private String titulo;
    @ManyToOne(fetch = FetchType.LAZY)
    private Autor autor;

}

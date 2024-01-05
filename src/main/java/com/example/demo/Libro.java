package com.example.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Setter
@Getter
@Entity
@Table(name = "Libro")
@EntityListeners(AuditingEntityListener.class)
public class Libro {
    @Id
    @Column(name = "idlibro")
    private Long idLibro;
    private String titulo;
    @ManyToOne(fetch = FetchType.LAZY)
    private Autor autor;

}

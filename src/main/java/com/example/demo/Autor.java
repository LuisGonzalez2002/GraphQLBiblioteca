package com.example.demo;

import jakarta.persistence.*;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "Autor")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Autor {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long idAutor;

    @Column(nullable = false)
    private String nombreCompleto;

}

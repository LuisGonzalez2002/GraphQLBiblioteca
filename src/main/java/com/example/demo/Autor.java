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
    @Column(name = "idautor")
    private Long idAutor;

    private String nombreCompleto;

}

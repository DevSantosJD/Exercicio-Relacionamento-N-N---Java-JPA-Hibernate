package com.example.editora.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_atuores")
@Data
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(unique = true)
    private String cpf;

    @ManyToMany(mappedBy = "autores")
    private Set<Livro> livros = new HashSet<>();

    public Autor(){}

    public Autor(String name, LocalDate dataNascimento, String cpf){
        this.name = name;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }
}

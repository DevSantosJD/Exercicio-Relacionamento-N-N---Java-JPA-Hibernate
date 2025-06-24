package com.example.editora.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_autores")
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

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "autores")
    @JsonBackReference
    private Set<Livro> livros = new HashSet<>();

    public Autor(){}

    public Autor(String name, LocalDate dataNascimento, String cpf){
        this.name = name;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }
}

package com.example.editora.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_livros")
@Data
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "livro_autor",
               joinColumns = @JoinColumn(name = "livro_id"),
               inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private Set<Autor> autores;

    public Livro(){}

    public Livro(String name){
        this.name = name;
    }
}

package com.example.editora.dto;

import com.example.editora.model.Autor;
import com.example.editora.model.Livro;

import java.util.Set;
import java.util.stream.Collectors;

public class LivroDTO {
    private Long id;
    private String name;
    private Set<String> autores;

    public LivroDTO(Livro livro){
        this.id = livro.getId();
        this.name = livro.getName();
        this.autores = livro.getAutores().stream()
                .map(Autor::getName)
                .collect(Collectors.toSet());
    }
}

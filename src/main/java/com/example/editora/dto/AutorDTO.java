package com.example.editora.dto;

import com.example.editora.model.Autor;
import com.example.editora.model.Livro;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class AutorDTO {
    private Long id;
    private String name;
    private LocalDate dataNascimento;
    private Set<String> livros;

    public AutorDTO(Autor autor){
        this.id = autor.getId();
        this.name = autor.getName();
        this.dataNascimento = autor.getDataNascimento();
        this.livros = autor.getLivros().stream()
                .map(Livro::getName)
                .collect(Collectors.toSet());
    }
}

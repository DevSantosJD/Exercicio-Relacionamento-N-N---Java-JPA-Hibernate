package com.example.editora.repository;

import com.example.editora.model.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    Page<Livro> findByAutoresId(Long autorId, Pageable pageable);
    Optional<Livro> findByName(String name);

}

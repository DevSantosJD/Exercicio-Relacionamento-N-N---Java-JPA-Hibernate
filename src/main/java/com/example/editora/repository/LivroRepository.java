package com.example.editora.repository;

import com.example.editora.model.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    Page<Livro> findByAutoresId(Long autorId, Pageable pageable);


}

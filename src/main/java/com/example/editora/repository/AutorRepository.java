package com.example.editora.repository;

import com.example.editora.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByName(String name);
}

package com.example.editora.controller;

import com.example.editora.model.Autor;
import com.example.editora.model.Livro;
import com.example.editora.service.EditoraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/editora")
public class EditoraController {

    private final EditoraService editoraService;

    public EditoraController(EditoraService editoraService){
        this.editoraService = editoraService;
    }

    // Publicar livro
    @PostMapping("/criar_livro")
    public Livro criarLivro(@RequestBody Livro livro){
        return editoraService.salvarLivro(livro);
    }

    // Cadastrar autor
    @PostMapping("/criar_autor")
    public Autor criarAutor(@RequestBody Autor autor){
        return editoraService.salvarAutor(autor);
    }

    // Listar todos livros publicados
    @GetMapping("/listar_livros")
    public List<Livro> listarLivros(){
        return editoraService.listarLivrois();
    }

    // Listar autores cadastrados
    @GetMapping("/listar_autores")
    public List<Autor> listarAutores(){
        return editoraService.listarAutores();
    }

    // Vincular autor a livro
    @PutMapping("/vincular_autor/{autorId}/livro/{livroId}")
    public ResponseEntity<?> vincularAutorLivro(@PathVariable Long autorId, @PathVariable Long livroId) {
        try {
            editoraService.vincularAutorLivro(autorId, livroId);
            return ResponseEntity.status(HttpStatus.CREATED).body("O autor " + autorId + " foi vinculado ao livro: " + livroId);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}

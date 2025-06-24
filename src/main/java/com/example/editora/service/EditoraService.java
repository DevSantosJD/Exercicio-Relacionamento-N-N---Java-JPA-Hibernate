package com.example.editora.service;

import com.example.editora.model.Autor;
import com.example.editora.model.Livro;
import com.example.editora.repository.AutorRepository;
import com.example.editora.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class EditoraService {

    private final AutorRepository autorRepository;
    private final LivroRepository livroRepository;

    public EditoraService(AutorRepository autorRepository, LivroRepository livroRepository){
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
    }

    // Salvar Livro
    public Livro salvarLivro(Livro livro){
        return livroRepository.save(livro);
    }

    // Salvar Autor
    public Autor salvarAutor(Autor autor){
        return autorRepository.save(autor);
    }

    // Listar Livros
    public List<Livro> listarLivrois(){
        return livroRepository.findAll();
    }

    // Listar Autores
    public List<Autor> listarAutores(){
        return autorRepository.findAll();
    }

    // Vincular autor a livro
    public void vincularAutorLivro(Long autorId, Long livroId){
        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(()-> new EntityNotFoundException("Autor não encontrado"));


        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(()-> new EntityNotFoundException("Livro não encontrado"));

        // verifica se Livro possui autores, se esta vazia
        if(!livro.getAutores().contains(autor)) {

            //Atualiza autor e livro
            livro.getAutores().add(autor);
            autor.getLivros().add(livro);

            livroRepository.save(livro);
            autorRepository.save(autor);


        }

    }

    // Remover autor de livro
    public void removerAutorLivro(Long autorId, Long livroId){
        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(()-> new EntityNotFoundException("Autor não encontrado com o ID: " + autorId));

         Livro livro = livroRepository.findById(livroId)
                 .orElseThrow(()-> new EntityNotFoundException("Livro não encontrado com ID: " + livroId));

         if(livro.getAutores().contains(autor)){

             livro.getAutores().remove(autor);
             autor.getLivros().remove(livro);

             autorRepository.save(autor);
             livroRepository.save(livro);

         }
    }

    // Buscar livro por autor(Id)

    public Page<Livro> buscarLivroPorAutor(Long autorId, Pageable pageable){
        Autor autor = autorRepository.findById(autorId)
                .orElseThrow(()-> new EntityNotFoundException("Autor não encontrado com o ID: " + autorId));
        return livroRepository.findByAutoresId(autorId, pageable);
    }

    // Buscar livro por nome do autor
    public Page<Livro> buscarLivrosPorNomeAutor(String nomeAutor, Pageable pageable){
        Autor autor = autorRepository.findByName(nomeAutor)
                .orElseThrow(()-> new EntityNotFoundException("Autor não encontrado " + nomeAutor +"não foi encontrado"));
        return livroRepository.findByAutoresId(autor.getId(), pageable);
    }

    // Retorna livro por nome
    public Optional<Livro> buscarLivroPorNome(String nameLivro){
        Livro livro = livroRepository.findByName(nameLivro)
                .orElseThrow(()-> new EntityNotFoundException("O livro " + nameLivro + " não foi encontrado"));

        return livroRepository.findByName(nameLivro);
    }

    //Remover autor
    public void apagarAutor(Long autorId){
        autorRepository.deleteById(autorId);
    }

    //Remover livro
    public void apagarLivro(Long livroId){
        livroRepository.deleteById(livroId);
    }
}

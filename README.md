# 📚 API REST Spring Boot: Relação N:N entre Livros e Autores

[![Java](https://img.shields.io/badge/Java-17+-blue.svg)](https://java.com)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1-green.svg)](https://spring.io/projects/spring-boot)

API RESTful desenvolvida com Spring Boot demonstrando um relacionamento muitos-para-muitos entre Livros e Autores, implementando as melhores práticas do ecossistema Spring.

## 🎯 Objetivos do Projeto
- Modelar a relação N:N: **Livro ↔ Autor** (Um livro pode ter vários autores, um autor pode escrever vários livros)
- Implementar operações CRUD completas
- Demonstrar arquitetura em camadas (Controller-Service-Repository)
- Aplicar recursos avançados do Spring Boot

## 🚀 Principais Funcionalidades
- Mapeamento de entidades com **JPA/Hibernate**
- **Validações** (`@Valid`, `@NotNull`)
- **Injeção de Dependência** (Spring IoC)
- **Tratamento personalizado de exceções** (`@ControllerAdvice`)
- Implementação do padrão **DTO**
- Suporte a **Paginação** (`Pageable`)
- **Arquitetura limpa** com separação de responsabilidades

## 💻 Implementação Técnica
### Modelo de Entidades
```java
@Entity
public class Livro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToMany
    @JoinTable(name = "livro_autor",
               joinColumns = @JoinColumn(name = "livro_id"),
               inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private Set<Autor> autores = new HashSet<>();
    // outros campos e métodos
}

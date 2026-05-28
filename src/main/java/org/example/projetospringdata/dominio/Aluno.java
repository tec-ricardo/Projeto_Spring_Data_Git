package org.example.projetospringdata.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private int cursosDisponiveis = 3;

    private Double nota;

    // GETTERS E SETTERS

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getCursosDisponiveis() { return cursosDisponiveis; }
    public void setCursosDisponiveis(int cursosDisponiveis) { this.cursosDisponiveis = cursosDisponiveis; }

    public Double getNota() { return nota; }
    public void setNota(Double nota) { this.nota = nota; }
}
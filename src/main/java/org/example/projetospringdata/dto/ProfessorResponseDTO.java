package org.example.projetospringdata.dto;

// DTO de saída para Professor
public class ProfessorResponseDTO {

    private long id;
    private String nome;
    private String email;
    private String disciplina;

    public ProfessorResponseDTO() {
    }

    public ProfessorResponseDTO(long id, String nome, String email, String disciplina) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.disciplina = disciplina;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDisciplina() {
        return disciplina;
    }
}
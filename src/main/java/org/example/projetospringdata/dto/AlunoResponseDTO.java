package org.example.projetospringdata.dto;

// DTO de saída da API para aluno
public class AlunoResponseDTO {

    private Long id;
    private String nome;
    private String email;

    public AlunoResponseDTO() {
    }

    public AlunoResponseDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
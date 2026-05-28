package org.example.projetospringdata.dto;

public class CursoResponseDTO {
    private String nome;
    private String descricao;

    public CursoResponseDTO() {
    }

    public CursoResponseDTO(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }


    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}

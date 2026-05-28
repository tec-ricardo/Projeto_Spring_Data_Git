package org.example.projetospringdata.dto;

public class MatriculaResponseDTO {

    private Long id;

    private String nomeAluno;

    private String nomeCurso;

    private Double nota;

    private String status;

    public MatriculaResponseDTO() {
    }

    public MatriculaResponseDTO(Long id,
                                String nomeAluno,
                                String nomeCurso,
                                Double nota,
                                String status) {

        this.id = id;
        this.nomeAluno = nomeAluno;
        this.nomeCurso = nomeCurso;
        this.nota = nota;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
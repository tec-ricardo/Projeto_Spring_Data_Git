package org.example.projetospringdata.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String nivel;
    private int cargaHoraria;
    private double mediaMinima;
    private boolean possuiProjeto;
    private int moedasGeradas;


    public Curso() {
    }


    public Curso(String nome, String descricao, String nivel, int cargaHoraria,
                 double mediaMinima, boolean possuiProjeto, int moedasGeradas) {
        this.nome = nome;
        this.descricao = descricao;
        this.nivel = nivel;
        this.cargaHoraria = cargaHoraria;
        this.mediaMinima = mediaMinima;
        this.possuiProjeto = possuiProjeto;
        this.moedasGeradas = moedasGeradas;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public double getMediaMinima() {
        return mediaMinima;
    }

    public void setMediaMinima(double mediaMinima) {
        this.mediaMinima = mediaMinima;
    }

    public boolean isPossuiProjeto() {
        return possuiProjeto;
    }

    public void setPossuiProjeto(boolean possuiProjeto) {
        this.possuiProjeto = possuiProjeto;
    }

    public int getMoedasGeradas() {
        return moedasGeradas;
    }

    public void setMoedasGeradas(int moedasGeradas) {
        this.moedasGeradas = moedasGeradas;
    }
}
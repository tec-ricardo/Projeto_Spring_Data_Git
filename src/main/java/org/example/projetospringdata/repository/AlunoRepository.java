package org.example.projetospringdata.repository;

import org.example.projetospringdata.dominio.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Transactional
    void deleteByNome(String nome);

    Aluno findByNome(String nome);
}
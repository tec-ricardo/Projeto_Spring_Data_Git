package org.example.projetospringdata.repository;

import org.example.projetospringdata.dominio.Aluno;
import org.example.projetospringdata.dominio.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    Optional<Matricula> findTopByAlunoOrderByIdDesc(Aluno aluno);

    @Transactional
    void deleteByAlunoId(Long alunoId);
}
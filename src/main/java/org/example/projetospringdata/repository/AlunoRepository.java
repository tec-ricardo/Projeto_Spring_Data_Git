package org.example.projetospringdata.repository;

import org.example.projetospringdata.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository <Aluno,Long> {
}

package org.example.projetospringdata.repository;

import org.example.projetospringdata.dominio.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Transactional
    void deleteByNome(String nome);
}
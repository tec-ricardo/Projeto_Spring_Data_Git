package org.example.projetospringdata.repository;

import org.example.projetospringdata.dominio.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Transactional
    void deleteByNome(String nome);
}

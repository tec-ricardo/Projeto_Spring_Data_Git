package org.example.projetospringdata.repository;

import org.example.projetospringdata.dominio.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long>{
}

package com.exemplo.usuariosimples.repository;

import com.exemplo.usuariosimples.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {

}

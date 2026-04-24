package org.example.projetospringdata.repository;


import org.example.projetospringdata.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {

}

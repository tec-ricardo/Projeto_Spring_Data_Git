package com.exemplo.usuariosimples.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exemplo.usuariosimples.domain.Professor;
import com.exemplo.usuariosimples.repository.ProfessorRepository;

@Service
public class ProfessorService {

    private final ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public Professor salvar(Professor professor) {
        return repository.save(professor);
    }

    public List<Professor> listar() {
        return repository.findAll();
    }

    public Professor buscar(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
package org.example.projetospringdata.service;

import org.example.projetospringdata.domain.Aluno;
import org.example.projetospringdata.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }


    public Aluno criar(Aluno aluno) {
        return repository.save(aluno);
    }


    public List<Aluno> listar() {
        return repository.findAll();
    }


    public Aluno buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com id: " + id));
    }


    public Aluno atualizar(Long id, Aluno dadosNovos) {
        Aluno existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com id: " + id));
        existente.setNome(dadosNovos.getNome());
        existente.setEmail(dadosNovos.getEmail());
        return repository.save(existente);
    }


    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
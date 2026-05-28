package org.example.projetospringdata.service;

import org.example.projetospringdata.dominio.Aluno;
import org.example.projetospringdata.repository.AlunoRepository;
import org.example.projetospringdata.repository.MatriculaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private MatriculaRepository matriculaRepository;

    public List<Aluno> listar() {
        return repository.findAll();
    }

    public Aluno buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Aluno salvar(Aluno aluno) {
        return repository.save(aluno);
    }

    public Aluno atualizar(Long id, Aluno aluno) {
        Aluno alunoExistente = buscar(id);

        if (alunoExistente != null) {
            alunoExistente.setNome(aluno.getNome());
            alunoExistente.setEmail(aluno.getEmail());
            alunoExistente.setNota(aluno.getNota());
            return repository.save(alunoExistente);
        }

        return null;
    }

    public void deletar(Long id) {
        matriculaRepository.deleteByAlunoId(id);
        repository.deleteById(id);
    }

    public void deletarPorNome(String nome) {
        Aluno aluno = repository.findByNome(nome);
        if (aluno != null) {
            matriculaRepository.deleteByAlunoId(aluno.getId());
            repository.delete(aluno);
        }
    }
}
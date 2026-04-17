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

    public List<Aluno> listar(){
        return repository.findAll();
    }

    public Aluno buscar(Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

    public Aluno salvar(Aluno aluno) {
        return repository.save(aluno);
    }
}

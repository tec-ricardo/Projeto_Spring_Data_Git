package org.example.projetospringdata.service;

import org.example.projetospringdata.dominio.Curso;
import org.example.projetospringdata.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository repository;

    public CursoService(CursoRepository repository){
        this.repository = repository;
    }

    public Curso criar(Curso curso) {
        return repository.save(curso);
    }

    public List<Curso> listarTodos() {
        return repository.findAll();
    }

    public Curso buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }

    public Curso atualizar(Long id, Curso curso) {
        Curso existente = buscarPorId(id);

        existente.setNome(curso.getNome());
        existente.setDescricao(curso.getDescricao());

        return repository.save(existente);
    }

    // DELETAR POR ID
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    // DELETAR POR NOME
    public void deletarPorNome(String nome) {
        repository.deleteByNome(nome);
    }
}

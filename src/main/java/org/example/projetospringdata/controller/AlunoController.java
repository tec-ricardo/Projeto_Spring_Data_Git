package org.example.projetospringdata.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.projetospringdata.dominio.Aluno;
import org.example.projetospringdata.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@Tag(name = "Aluno", description = "Endpoints de Cadastro de Alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    // GET /alunos
    @GetMapping
    public List<Aluno> listar() {
        return service.listar();
    }

    // GET /alunos/{id}
    @GetMapping("/{id}")
    public Aluno buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    // POST /alunos
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno salvar(@RequestBody Aluno aluno) {
        return service.salvar(aluno);
    }

    // PUT /alunos/{id}
    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
        return service.atualizar(id, aluno);
    }

    // DELETE /alunos/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    // DELETE /alunos/nome/{nome}
    @DeleteMapping("/nome/{nome}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remove um aluno pelo nome")
    public void deletarPorNome(@PathVariable String nome) {
        service.deletarPorNome(nome);
    }
}

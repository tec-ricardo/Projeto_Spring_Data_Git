package org.example.projetospringdata.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.projetospringdata.dominio.Professor;
import org.example.projetospringdata.service.ProfessorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
@Tag(name = "Professores", description = "Endpoints de Cadastro de Professores")
@CrossOrigin(origins = "*")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<Professor> listar() {
        return professorService.listar();
    }

    @GetMapping("/{id}")
    public Professor buscar(@PathVariable Long id) {
        return professorService.buscar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Professor criar(@RequestBody Professor professor) {
        return professorService.salvar(professor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        professorService.deletar(id);
    }

    // DELETE /professores/nome/{nome}
    @DeleteMapping("/nome/{nome}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remove um professor pelo nome")
    public void deletarPorNome(@PathVariable String nome) {
        professorService.deletarPorNome(nome);
    }
}

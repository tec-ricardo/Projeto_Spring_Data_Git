package org.example.projetospringdata.controller;

import org.example.projetospringdata.dto.MatriculaRequestDTO;
import org.example.projetospringdata.dominio.Matricula;
import org.example.projetospringdata.service.MatriculaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matriculas")
@Tag(name = "Matrículas", description = "Endpoints de Cadastro de Matrículas")
@CrossOrigin("*")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    // MATRICULAR ALUNO

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Matricular aluno em um curso")
    public Matricula matricular(
            @Valid @RequestBody MatriculaRequestDTO dto
    ){
        return matriculaService.matricular(dto.getAlunoId(), dto.getCursoId());
    }

    // CONCLUIR CURSO

    @PutMapping("/concluir")
    @Operation(summary = "Concluir curso com nota")
    public Matricula concluirCurso(
            @RequestParam Long alunoId,
            @RequestParam Double nota
    ){
        return matriculaService.concluirCurso(alunoId, nota);
    }
}
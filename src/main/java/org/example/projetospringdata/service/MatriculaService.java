package org.example.projetospringdata.service;

import org.example.projetospringdata.dominio.Aluno;
import org.example.projetospringdata.dominio.Curso;
import org.example.projetospringdata.dominio.Matricula;
import org.example.projetospringdata.repository.AlunoRepository;
import org.example.projetospringdata.repository.CursoRepository;
import org.example.projetospringdata.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    // MATRICULAR

    public Matricula matricular(Long alunoId, Long cursoId) {

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        if (aluno.getCursosDisponiveis() <= 0) {
            throw new RuntimeException("Sem cursos disponíveis");
        }

        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);
        matricula.setCurso(curso);

        aluno.setCursosDisponiveis(aluno.getCursosDisponiveis() - 1);
        alunoRepository.save(aluno);

        return matriculaRepository.save(matricula);
    }

    // CONCLUIR CURSO

    public Matricula concluirCurso(Long alunoId, Double nota) {

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Matricula matricula = matriculaRepository.findTopByAlunoOrderByIdDesc(aluno)
                .orElseThrow(() -> new RuntimeException("Nenhuma matrícula encontrada"));

        matricula.setNota(nota);

        aluno.setNota(nota);
        aluno.setCursosDisponiveis(aluno.getCursosDisponiveis() + 3);

        alunoRepository.save(aluno);

        return matriculaRepository.save(matricula);
    }
}
const API = 'http://localhost:8080';

async function salvarAluno() {
    const nome = document.getElementById("nomeAluno").value;
    const email = document.getElementById("emailAluno").value;
    await fetch(API + "/alunos", { method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify({ nome, email }) });
    alert("Aluno salvo com sucesso!");
}

async function listarAlunos() {
    const resposta = await fetch(API + "/alunos");
    const alunos = await resposta.json();
    document.getElementById("listaAlunos").innerHTML = alunos.map(aluno =>
        `<li>${aluno.id} - ${aluno.nome} | email: ${aluno.email} | nota: ${aluno.nota ?? 'sem nota'} | cursos disponíveis: ${aluno.cursosDisponiveis}</li>`
    ).join("");
}

async function deletarAlunoPorNome() {
    const nome = document.getElementById("nomeAlunoDelete").value.trim();
    if (!nome) { alert("Informe o nome do aluno para deletar."); return; }
    if (!confirm(`Tem certeza que deseja deletar o aluno "${nome}"?`)) return;
    const resposta = await fetch(API + `/alunos/nome/${encodeURIComponent(nome)}`, { method: "DELETE" });
    if (resposta.ok || resposta.status === 204) { alert(`Aluno "${nome}" deletado!`); document.getElementById("nomeAlunoDelete").value = ""; listarAlunos(); }
    else alert(`Erro ao deletar aluno "${nome}".`);
}

async function salvarCurso() {
    const nome = document.getElementById("nomeCurso").value;
    const descricao = document.getElementById("descricaoCurso").value;
    await fetch(API + "/cursos", { method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify({ nome, descricao }) });
    alert("Curso salvo com sucesso!");
}

async function listarCursos() {
    const resposta = await fetch(API + "/cursos");
    const cursos = await resposta.json();
    document.getElementById("listaCursos").innerHTML = cursos.map(curso =>
        `<div class="card"><h3>${curso.nome}</h3><p>ID: ${curso.id}</p><p>${curso.descricao}</p></div>`
    ).join("");
}

async function deletarCursoPorNome() {
    const nome = document.getElementById("nomeCursoDelete").value.trim();
    if (!nome) { alert("Informe o nome do curso para deletar."); return; }
    if (!confirm(`Tem certeza que deseja deletar o curso "${nome}"?`)) return;
    const resposta = await fetch(API + `/cursos/nome/${encodeURIComponent(nome)}`, { method: "DELETE" });
    if (resposta.ok || resposta.status === 204) { alert(`Curso "${nome}" deletado!`); document.getElementById("nomeCursoDelete").value = ""; listarCursos(); }
    else alert(`Erro ao deletar curso "${nome}".`);
}

async function salvarProfessor() {
    const nome = document.getElementById("nomeProfessor").value;
    const email = document.getElementById("emailProfessor").value;
    const disciplina = document.getElementById("disciplinaProfessor").value;
    await fetch(API + "/professores", { method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify({ nome, email, disciplina }) });
    alert("Professor salvo com sucesso!");
}

async function listarProfessores() {
    const resposta = await fetch(API + "/professores");
    const professores = await resposta.json();
    document.getElementById("listaProfessores").innerHTML = professores.map(professor =>
        `<div class="card"><h3>${professor.nome}</h3><p>${professor.email}</p><p>${professor.disciplina}</p></div>`
    ).join("");
}

async function deletarProfessorPorNome() {
    const nome = document.getElementById("nomeProfessorDelete").value.trim();
    if (!nome) { alert("Informe o nome do professor para deletar."); return; }
    if (!confirm(`Tem certeza que deseja deletar o professor "${nome}"?`)) return;
    const resposta = await fetch(API + `/professores/nome/${encodeURIComponent(nome)}`, { method: "DELETE" });
    if (resposta.ok || resposta.status === 204) { alert(`Professor "${nome}" deletado!`); document.getElementById("nomeProfessorDelete").value = ""; listarProfessores(); }
    else alert(`Erro ao deletar professor "${nome}".`);
}

async function matricularAluno() {
    const alunoId = document.getElementById("idAlunoMatricula").value;
    const cursoId = document.getElementById("idCursoMatricula").value;
    await fetch(API + "/matriculas", { method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify({ alunoId, cursoId }) });
    alert("Aluno matriculado com sucesso!");
}

async function concluirCurso() {
    const alunoId = document.getElementById("idMatriculaConclusao").value;
    const nota = document.getElementById("notaConclusao").value;
    await fetch(API + `/matriculas/concluir?alunoId=${alunoId}&nota=${nota}`, { method: "PUT" });
    if (nota >= 7) alert("Aluno aprovado! +3 cursos liberados!");
    else alert("Aluno reprovado.");
    listarAlunos();
}
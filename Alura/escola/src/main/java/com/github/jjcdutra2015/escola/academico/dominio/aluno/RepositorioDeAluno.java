package com.github.jjcdutra2015.escola.academico.dominio.aluno;

import com.github.jjcdutra2015.escola.shared.dominio.CPF;

import java.util.List;

public interface RepositorioDeAluno {

    void matricular(Aluno aluno);

    Aluno buscarPorCPF(CPF cpf);

    List<Aluno> listarTodosAlunosMatriculados();
}

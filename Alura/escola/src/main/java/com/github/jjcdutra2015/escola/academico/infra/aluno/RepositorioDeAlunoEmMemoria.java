package com.github.jjcdutra2015.escola.academico.infra.aluno;

import com.github.jjcdutra2015.escola.academico.dominio.aluno.Aluno;
import com.github.jjcdutra2015.escola.academico.dominio.aluno.AlunoNaoEncontrado;
import com.github.jjcdutra2015.escola.shared.dominio.CPF;
import com.github.jjcdutra2015.escola.academico.dominio.aluno.RepositorioDeAluno;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunoEmMemoria implements RepositorioDeAluno {

    List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.matriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        return this.matriculados.stream()
                .filter(a -> a.getCpf().equals(cpf.getCampo()))
                .findFirst()
                .orElseThrow(() -> new AlunoNaoEncontrado(cpf));
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return this.matriculados;
    }
}

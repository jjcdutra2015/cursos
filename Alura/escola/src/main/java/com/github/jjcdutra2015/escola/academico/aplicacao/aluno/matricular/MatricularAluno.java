package com.github.jjcdutra2015.escola.academico.aplicacao.aluno.matricular;

import com.github.jjcdutra2015.escola.shared.dominio.evento.PublicadorDeEventos;
import com.github.jjcdutra2015.escola.academico.dominio.aluno.Aluno;
import com.github.jjcdutra2015.escola.academico.dominio.aluno.AlunoMatriculado;
import com.github.jjcdutra2015.escola.academico.dominio.aluno.RepositorioDeAluno;

public class MatricularAluno {

    private final RepositorioDeAluno repositorio;
    private final PublicadorDeEventos publicador;

    public MatricularAluno(RepositorioDeAluno repositorio, PublicadorDeEventos publicador) {
        this.repositorio = repositorio;
        this.publicador = publicador;
    }

    public void executa(MatricularAlunoDto dados) {
        Aluno novo = dados.criarAluno();
        repositorio.matricular(novo);

        AlunoMatriculado evento = new AlunoMatriculado(novo.getCpf());
        publicador.publicar(evento);
    }
}

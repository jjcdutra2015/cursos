package com.github.jjcdutra2015.escola;

import com.github.jjcdutra2015.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import com.github.jjcdutra2015.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import com.github.jjcdutra2015.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import com.github.jjcdutra2015.escola.academico.infra.aluno.RepositorioDeAlunoEmMemoria;
import com.github.jjcdutra2015.escola.gamificacao.aplicacao.GerarSeloAlunoNovato;
import com.github.jjcdutra2015.escola.gamificacao.infra.selo.RepositorioDeSeloEmMemoria;
import com.github.jjcdutra2015.escola.shared.dominio.evento.PublicadorDeEventos;

public class MatricularAlunoPorLinhaDeComando {

    public static void main(String[] args) {
        String cpf = "123.456.789-00";
        String nome = "Fulano da Silva";
        String email = "fulano@email.com";

        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new LogDeAlunoMatriculado());
        publicador.adicionar(new GerarSeloAlunoNovato(new RepositorioDeSeloEmMemoria()));

        MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunoEmMemoria(), publicador);
        matricular.executa(new MatricularAlunoDto(cpf, nome, email));
    }
}

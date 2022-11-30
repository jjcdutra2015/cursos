package com.github.jjcdutra2015.escola.academico.aplicacao.aluno;

import com.github.jjcdutra2015.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import com.github.jjcdutra2015.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import com.github.jjcdutra2015.escola.shared.dominio.evento.PublicadorDeEventos;
import com.github.jjcdutra2015.escola.academico.dominio.aluno.Aluno;
import com.github.jjcdutra2015.escola.shared.dominio.CPF;
import com.github.jjcdutra2015.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import com.github.jjcdutra2015.escola.academico.infra.aluno.RepositorioDeAlunoEmMemoria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatricularAlunoTest {

    @Test
    void devePersistirAluno() {
        RepositorioDeAlunoEmMemoria repositorio = new RepositorioDeAlunoEmMemoria();

        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new LogDeAlunoMatriculado());

        MatricularAluno useCase = new MatricularAluno(repositorio, publicador);

        MatricularAlunoDto dados = new MatricularAlunoDto(
                "123.456.789-00",
                "Fulano",
                "fulano@email.com");
        useCase.executa(dados);

        Aluno encontrado = repositorio.buscarPorCPF(new CPF("123.456.789-00"));

        assertEquals("Fulano", encontrado.getNome());
        assertEquals("123.456.789-00", encontrado.getCpf());
        assertEquals("fulano@email.com", encontrado.getEmail());
    }
}
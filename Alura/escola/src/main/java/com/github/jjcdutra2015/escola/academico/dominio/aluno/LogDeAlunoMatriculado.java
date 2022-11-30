package com.github.jjcdutra2015.escola.academico.dominio.aluno;

import com.github.jjcdutra2015.escola.shared.dominio.evento.Evento;
import com.github.jjcdutra2015.escola.shared.dominio.evento.Ouvinte;

import java.time.format.DateTimeFormatter;

public class LogDeAlunoMatriculado extends Ouvinte {

    @Override
    protected void reageAo(Evento evento) {
        String momentoFormatado = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.println(
                String.format("Aluno com CPF %s matriculado em: %s",
                        ((AlunoMatriculado) evento).getCpfDoAluno(),
                        momentoFormatado));
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}

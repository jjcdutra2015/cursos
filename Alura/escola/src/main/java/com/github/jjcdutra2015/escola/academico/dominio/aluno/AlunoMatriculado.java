package com.github.jjcdutra2015.escola.academico.dominio.aluno;

import com.github.jjcdutra2015.escola.shared.dominio.CPF;
import com.github.jjcdutra2015.escola.shared.dominio.evento.Evento;
import com.github.jjcdutra2015.escola.shared.dominio.evento.TipoEvento;

import java.time.LocalDateTime;
import java.util.Map;

public class AlunoMatriculado implements Evento {

    private final CPF cpfDoAluno;
    private final LocalDateTime momento;

    public AlunoMatriculado(CPF cpfDoAluno) {
        this.cpfDoAluno = cpfDoAluno;
        this.momento = LocalDateTime.now();
    }

    public CPF getCpfDoAluno() {
        return cpfDoAluno;
    }

    @Override
    public LocalDateTime momento() {
        return this.momento;
    }

    @Override
    public TipoEvento tipo() {
        return TipoEvento.ALUNO_MATRICULADO;
    }

    @Override
    public Map<String, Object> informacoes() {
        return Map.of("cpf", this.cpfDoAluno);
    }

}

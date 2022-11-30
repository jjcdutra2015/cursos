package com.github.jjcdutra2015.escola.academico.dominio.aluno;

import com.github.jjcdutra2015.escola.shared.dominio.CPF;

public class AlunoNaoEncontrado extends RuntimeException {

    public AlunoNaoEncontrado(CPF cpf) {
        super("Aluno não encontrado com o CPF: " + cpf.getCampo());
    }
}

package com.github.jjcdutra2015.escola.academico.aplicacao.aluno.matricular;

import com.github.jjcdutra2015.escola.academico.dominio.aluno.Aluno;
import com.github.jjcdutra2015.escola.shared.dominio.CPF;
import com.github.jjcdutra2015.escola.academico.dominio.aluno.Email;

public class MatricularAlunoDto {

    private String cpfAluno;
    private String nomeAluno;
    private String emailAluno;

    public MatricularAlunoDto(String cpfAluno, String nomeAluno, String emailAluno) {
        this.cpfAluno = cpfAluno;
        this.nomeAluno = nomeAluno;
        this.emailAluno = emailAluno;
    }

    public Aluno criarAluno() {
        return new Aluno(new CPF(cpfAluno), nomeAluno, new Email(emailAluno));
    }
}

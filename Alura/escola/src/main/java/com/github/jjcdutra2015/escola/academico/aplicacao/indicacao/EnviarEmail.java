package com.github.jjcdutra2015.escola.academico.aplicacao.indicacao;

import com.github.jjcdutra2015.escola.academico.dominio.aluno.Aluno;

public interface EnviarEmail {

    void enviarPara(Aluno indicado);
}

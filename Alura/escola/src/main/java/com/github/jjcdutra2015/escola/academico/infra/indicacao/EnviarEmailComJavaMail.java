package com.github.jjcdutra2015.escola.academico.infra.indicacao;

import com.github.jjcdutra2015.escola.academico.aplicacao.indicacao.EnviarEmail;
import com.github.jjcdutra2015.escola.academico.dominio.aluno.Aluno;

public class EnviarEmailComJavaMail implements EnviarEmail {

    @Override
    public void enviarPara(Aluno indicado) {
        // Regra do java mail
    }
}

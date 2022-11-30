package com.github.jjcdutra2015.escola.gamificacao.dominio.selo;

import com.github.jjcdutra2015.escola.shared.dominio.CPF;

import java.util.List;

public interface RepositorioDeSelo {

    void adicionar(Selo selo);

    List<Selo> selosDoAlunoDeCPF(CPF cpf);
}

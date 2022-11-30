package com.github.jjcdutra2015.escola.gamificacao.infra.selo;

import com.github.jjcdutra2015.escola.gamificacao.dominio.selo.RepositorioDeSelo;
import com.github.jjcdutra2015.escola.gamificacao.dominio.selo.Selo;
import com.github.jjcdutra2015.escola.shared.dominio.CPF;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeSeloEmMemoria implements RepositorioDeSelo {

    private List<Selo> selos = new ArrayList<>();

    @Override
    public void adicionar(Selo selo) {
        this.selos.add(selo);
    }

    @Override
    public List<Selo> selosDoAlunoDeCPF(CPF cpf) {
        return this.selos.stream().filter(s -> s.getCpf() == cpf).collect(Collectors.toList());
    }
}

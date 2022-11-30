package com.github.jjcdutra2015.escola.gamificacao.aplicacao;

import com.github.jjcdutra2015.escola.gamificacao.dominio.selo.Selo;
import com.github.jjcdutra2015.escola.gamificacao.infra.selo.RepositorioDeSeloEmMemoria;
import com.github.jjcdutra2015.escola.shared.dominio.CPF;
import com.github.jjcdutra2015.escola.shared.dominio.evento.Evento;
import com.github.jjcdutra2015.escola.shared.dominio.evento.Ouvinte;
import com.github.jjcdutra2015.escola.shared.dominio.evento.TipoEvento;

public class GerarSeloAlunoNovato extends Ouvinte {

    private final RepositorioDeSeloEmMemoria repositorioDeSelo;

    public GerarSeloAlunoNovato(RepositorioDeSeloEmMemoria repositorioDeSelo) {
        this.repositorioDeSelo = repositorioDeSelo;
    }

    @Override
    protected void reageAo(Evento evento) {
        CPF cpfDoAluno = (CPF) evento.informacoes().get("cpf");
        Selo novato = new Selo(cpfDoAluno, "Novato");
        repositorioDeSelo.adicionar(novato);
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento.tipo() == TipoEvento.ALUNO_MATRICULADO;
    }
}

package com.github.jjcdutra2015.escola.academico.dominio.aluno;

import com.github.jjcdutra2015.escola.shared.dominio.CPF;

import java.util.ArrayList;
import java.util.List;

//AGGREGATE ROOT
public class Aluno {

    private CPF cpf;
    private String nome;
    private Email email;
    private List<Telefone> telefones = new ArrayList<>();

    private String senha;

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEndereco();
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void adicionarTelefone(String ddd, String numero) {
        if (telefones.size() == 2) {
            throw new BusinessException("Aluno não pode ter mas de dois telefones cadastrados!");
        }
        this.telefones.add(new Telefone(ddd, numero));
    }
}

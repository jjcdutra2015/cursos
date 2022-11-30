package com.github.jjcdutra2015.escola.shared.dominio;

public class CPF {

    private String campo;

    public CPF(String campo) {
        if (campo == null || !campo.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("escola.CPF inválido!");
        }
        this.campo = campo;
    }

    public String getCampo() {
        return campo;
    }
}

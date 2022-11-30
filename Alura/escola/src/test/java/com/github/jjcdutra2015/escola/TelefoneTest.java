package com.github.jjcdutra2015.escola;

import com.github.jjcdutra2015.escola.academico.dominio.aluno.Telefone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TelefoneTest {

    @Test
    public void naoDeveriaCriarTelefoneComDddENumeroNulos() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, null));
    }

    @Test
    public void naoDeveriaCriarTelefoneComDddENumeroInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone("", ""));

        assertThrows(IllegalArgumentException.class, () -> new Telefone("123", "1234"));
    }

    @Test
    public void deveCriarTelefoneComDddETelefoneValidos() {
        String ddd = "22";
        String numero = "999512651";
        Telefone telefone = new Telefone(ddd, numero);

        assertEquals(ddd, telefone.getDdd());
        assertEquals(numero, telefone.getNumero());
    }
}
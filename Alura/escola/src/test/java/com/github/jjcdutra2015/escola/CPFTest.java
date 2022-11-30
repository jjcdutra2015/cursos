package com.github.jjcdutra2015.escola;

import com.github.jjcdutra2015.escola.shared.dominio.CPF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CPFTest {

    @Test
    public void naoDeveriaCriarCPFComCampoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));

        assertThrows(IllegalArgumentException.class, () -> new CPF(""));

        assertThrows(IllegalArgumentException.class, () -> new CPF("123456"));
    }

    @Test
    public void deveCriarCPFValido() {
        CPF cpf = new CPF("484.501.810-11");
        assertEquals("484.501.810-11", cpf.getCampo());
    }
}
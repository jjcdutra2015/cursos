package com.github.jjcdutra2015.escola;

import com.github.jjcdutra2015.escola.academico.dominio.aluno.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailTest {

    @Test
    public void naoDeveriaCriarEmailComEnderecoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));

        assertThrows(IllegalArgumentException.class, () -> new Email(""));

        assertThrows(IllegalArgumentException.class, () -> new Email("emailinvalido"));
    }

    @Test
    public void deveCriarEmailValido() {
        Email email = new Email("email@email.com");
        assertEquals("email@email.com", email.getEndereco());
    }
}
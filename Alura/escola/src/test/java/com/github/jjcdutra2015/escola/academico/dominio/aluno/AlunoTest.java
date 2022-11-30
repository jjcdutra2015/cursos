package com.github.jjcdutra2015.escola.academico.dominio.aluno;

import com.github.jjcdutra2015.escola.shared.dominio.CPF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    void setUp() {
        this.aluno = new Aluno(
                new CPF("123.456.789-00"),
                "Fulano",
                new Email("fulano@emal.com"));
    }

    @Test
    void deveCriarAlunoCom1Telefone() {
        aluno.adicionarTelefone("22", "999512651");

        assertEquals(1, aluno.getTelefones().size());
    }

    @Test
    void deveCriarAlunoCom2Telefones() {
        aluno.adicionarTelefone("22", "999512651");

        assertEquals(1, aluno.getTelefones().size());
    }

    @Test
    void naoDeveCriarAlunoCom3OuMaisTelefones() {
        assertThrows(BusinessException.class, () -> {
            aluno.adicionarTelefone("22", "999512651");
            aluno.adicionarTelefone("22", "999512651");
            aluno.adicionarTelefone("22", "999512651");
        });
    }
}
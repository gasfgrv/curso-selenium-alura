package br.com.alura.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginTest {

    private LoginPage paginaLogin;

    @BeforeEach
    void beforeEach() {
        this.paginaLogin = new LoginPage();
    }

    @AfterEach
    void afterEach() {
        paginaLogin.fechar();
    }

    @Test
    void deveriaEfetuarLoginComDadosValidos() {
        paginaLogin.preencheFormularioDeLogin("fulano", "pass");
        paginaLogin.submeteFormulario();

        assertFalse(paginaLogin.isPaginaDeLogin());
        assertEquals("fulano", paginaLogin.getNomeUsuarioLogado());
    }

    @Test
    void naoDeveriaLogarComDadosInvalidos() {
        paginaLogin.preencheFormularioDeLogin("invalido", "132123");
        paginaLogin.submeteFormulario();

        assertTrue(paginaLogin.isPaginaDeLoginInvalido());
        assertNull(paginaLogin.getNomeUsuarioLogado());
        assertTrue(paginaLogin.contemTexto("Usuário e senha inválidos."));
    }

    @Test
    void naoDeveriaAcessarpaginaRestritaSemEstarLogado() {
        paginaLogin.navegarParaPaginaDelances();

        assertTrue(paginaLogin.isPaginaDeLogin());
        assertFalse(paginaLogin.contemTexto("Dados do Leilão"));
    }

}

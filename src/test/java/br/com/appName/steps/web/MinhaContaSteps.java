package br.com.appName.steps.web;

import br.com.application.name.web.funcionalidade.MinhaContaFuncionalidade;
import cucumber.api.java.pt.Entao;
import org.junit.jupiter.api.Assertions;

public class MinhaContaSteps {

    private MinhaContaFuncionalidade minhaContaFuncionalidade;

    public MinhaContaSteps() {
        this.minhaContaFuncionalidade = new MinhaContaFuncionalidade();
    }

    @Entao("^visualizo a tela de My Account$")
    public void visualizoATelaDeMyAccount() {
        Assertions.assertTrue(this.minhaContaFuncionalidade.retornaAcessoLogin());
    }
}

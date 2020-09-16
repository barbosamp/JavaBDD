package br.com.appName.steps.web;

import br.com.application.name.web.funcionalidade.MinhaContaFuncionalidade;
import cucumber.api.PendingException;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.jupiter.api.Assertions;

public class MinhaContaSteps {

    private MinhaContaFuncionalidade  minhaContaFuncionalidade;

    public MinhaContaSteps(){
        this.minhaContaFuncionalidade = new MinhaContaFuncionalidade();
    }


    @E("^acesso a tela de informações do usuario$")
    public void acessoATelaInformacoes(){
        this.minhaContaFuncionalidade.acessaTelaEditarDados();
    }

    @Quando("^altero o nome do usuario$")
    public void alteroONomeDoUsuario() {
        this.minhaContaFuncionalidade.editaDadosUsuario();
    }

    @Entao("^visualizo a mensagem \"([^\"]*)\" na tela de conta$")
    public void visualizoAMensagemNaTelaDeConta(String mensagem) {
        Assertions.assertEquals(mensagem,this.minhaContaFuncionalidade.retornaMensagem());
    }
}

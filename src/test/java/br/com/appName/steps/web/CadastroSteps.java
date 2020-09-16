package br.com.appName.steps.web;

import br.com.application.name.web.funcionalidade.RegistroFuncionalidade;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.jupiter.api.Assertions;

public class CadastroSteps {

    private RegistroFuncionalidade registroFuncionalidade;

    public CadastroSteps(){
        this.registroFuncionalidade = new RegistroFuncionalidade();
    }

    @Dado("^preencho os dados validos de cadastro$")
    public void preenchoDadosValidosCadastro() {
        this.registroFuncionalidade.preencheFormulario();
    }

    @Entao("^visualizo a mensagem \"([^\"]*)\"$")
    public void visualizoAMensagem(String mensagemTela) {
        Assertions.assertEquals(mensagemTela,this.registroFuncionalidade.retornaMensagemRegistro());
    }

    @Quando("^clico no botao \"([^\"]*)\"$")
    public void clicoNoBotao(String nomeBotao) {
        this.registroFuncionalidade.confirmaRegistro(true);

    }
}

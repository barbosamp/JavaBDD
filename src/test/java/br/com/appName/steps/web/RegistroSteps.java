package br.com.appName.steps.web;

import br.com.application.name.web.funcionalidade.RegistroFuncionalidade;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import org.junit.jupiter.api.Assertions;

public class RegistroSteps    {

    private RegistroFuncionalidade registroFuncionalidade;

    public RegistroSteps(){
        this.registroFuncionalidade = new RegistroFuncionalidade();
    }

    @Dado("^preencho os dados validos de cadastro$")
    public void preenchoDadosValidosCadastro() {
        this.registroFuncionalidade.preencheFormulario();
        this.registroFuncionalidade.confirmaRegistro(true);
    }

    @Entao("^visualizo a mensagem \"([^\"]*)\"$")
    public void visualizoAMensagem(String mensagemTela) {
        Assertions.assertEquals(mensagemTela,this.registroFuncionalidade.retornaMensagemRegistro());
    }
}

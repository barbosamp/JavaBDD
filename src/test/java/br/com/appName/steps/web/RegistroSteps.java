package br.com.appName.steps.web;

import br.com.application.name.web.funcionalidade.RegistroFuncionalidade;
import cucumber.api.java.pt.Dado;

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
}

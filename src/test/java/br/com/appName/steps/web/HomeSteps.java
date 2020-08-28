package br.com.appName.steps.web;

import br.com.application.name.web.funcionalidade.InicioFuncionalidade;
import cucumber.api.java.pt.E;

public class HomeSteps {

    private InicioFuncionalidade inicioFuncionalidade;

    public HomeSteps() {
            this.inicioFuncionalidade =  new InicioFuncionalidade();
    }

    @E("^acesso a tela de registro$")
    public void estouRealizandoOTeste(){
            this.inicioFuncionalidade.acessaRegistroNovoUsuario();
    }

    @E("^acesso a tela de login$")
    public void acessoATelaDeLogin() {
            this.inicioFuncionalidade.acessaLoginUsuario();
    }
}

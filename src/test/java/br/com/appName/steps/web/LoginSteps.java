package br.com.appName.steps.web;

import br.com.application.name.web.funcionalidade.LoginFuncionalidade;
import cucumber.api.java.pt.E;

public class LoginSteps {
    private LoginFuncionalidade loginFuncionalidade;

    public LoginSteps(){
        this.loginFuncionalidade = new LoginFuncionalidade();
    }

    @E("^realizo login no sistema com usuario cadastrado$")
    public void realizoLoginNoSistemausuarioValido(){
        this.loginFuncionalidade.realizaLoginUsuario();
    }
}

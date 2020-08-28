package br.com.appName.steps.web;

import br.com.application.name.web.funcionalidade.LoginFuncionalidade;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Quando;

public class LoginSteps {

    private LoginFuncionalidade loginFuncionalidade;

    public LoginSteps() {
        this.loginFuncionalidade = new LoginFuncionalidade();
    }

    @Quando("^insiro credenciais do tipo \"([^\"]*)\"$")
    public void insiroCredenciais(String tipoUsuario){
        this.loginFuncionalidade.realizaLogin(tipoUsuario);
    }
}

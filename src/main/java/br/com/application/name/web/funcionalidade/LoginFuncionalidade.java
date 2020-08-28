package br.com.application.name.web.funcionalidade;

import br.com.application.name.commons.BaseTest;
import br.com.application.name.enums.UserCredential;
import br.com.application.name.interfaces.Credentials;
import br.com.application.name.web.pages.LoginPage;
import br.com.application.name.web.pages.MinhaContaPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginFuncionalidade extends BaseTest {
    private LoginPage loginPage;
    private MinhaContaPage minhaContaPage;

    public LoginFuncionalidade(){
         this.loginPage = new LoginPage(webDriver);
         this.minhaContaPage = new MinhaContaPage(webDriver);
    }

    public void realizaLogin(String tipoUsuario){
        Credentials credentials = UserCredential.valueOf(tipoUsuario.toUpperCase());
        this.loginPage.getEmailAddress().sendKeys(credentials.email());
        this.loginPage.getPassword().sendKeys(credentials.password());
        addEvidenciaWeb("Credenciais inseridas. " +
                "Email: " + credentials.email() + "\n Senha: " + credentials.password() );
        this.loginPage.getBtLogin().click();

    }


}

package br.com.application.name.web.funcionalidade;

import br.com.application.name.commons.BaseTest;
import br.com.application.name.web.pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeFuncionalidade extends BaseTest {

    private HomePage homePage;

    public HomeFuncionalidade(){
        this.homePage = new HomePage(webDriver);
    }

    public void acessaRegistroNovoUsuario(){
        wait.until(ExpectedConditions.visibilityOf(this.homePage.getLblLogoInicial()));
        this.homePage.getBtMyAccount().click();
        addEvidenciaWeb("Acessando tela de registro.");
        this.homePage.getBtRegister().click();
    }


}

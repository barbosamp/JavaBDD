package br.com.application.name.web.funcionalidade;

import br.com.application.name.commons.BaseTest;
import br.com.application.name.commons.PropertiesManager;
import br.com.application.name.web.pages.HomePage;
import br.com.application.name.web.pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginFuncionalidade extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;

    public LoginFuncionalidade() {
        this.loginPage = new LoginPage(webDriver);
        this.homePage = new HomePage(webDriver);
    }

    public void realizaLoginUsuario(){
        wait.until(ExpectedConditions.visibilityOf(this.homePage.getLblLogoInicial()));
        this.homePage.getBtMyAccount().click();
        this.homePage.getBtLogin().click();
        wait.until(ExpectedConditions.visibilityOf(this.loginPage.getEmailAddress()));
        this.loginPage.getEmailAddress().sendKeys(PropertiesManager.getPropertiesValue("EMAIL"));
        this.loginPage.getPassword().sendKeys(PropertiesManager.getPropertiesValue("PASSWORD"));
        this.loginPage.getBtLogin().click();
    }
}

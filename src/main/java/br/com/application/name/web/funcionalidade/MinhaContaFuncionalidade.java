package br.com.application.name.web.funcionalidade;

import br.com.application.name.commons.BaseTest;
import br.com.application.name.web.pages.MinhaContaPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MinhaContaFuncionalidade extends BaseTest {

    private MinhaContaPage minhaContaPage;

    public MinhaContaFuncionalidade() {
        this.minhaContaPage = new MinhaContaPage(webDriver);
    }

    public boolean retornaAcessoLogin(){
        wait.until(ExpectedConditions.visibilityOf(this.minhaContaPage.getLblMyAccount()));
        addEvidenciaWeb("Login realizado com sucesso!");
        return this.minhaContaPage.getLblMyAccount().isDisplayed();
    }
}

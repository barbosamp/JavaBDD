package br.com.application.name.web.funcionalidade;

import br.com.application.name.commons.BaseTest;
import br.com.application.name.web.pages.LoginPage;
import br.com.application.name.web.pages.MinhaContaPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MinhaContaFuncionalidade extends BaseTest {

    private MinhaContaPage minhaContaPage;

    public MinhaContaFuncionalidade(){
        this.minhaContaPage = new MinhaContaPage(webDriver);
    }

    public void acessaTelaEditarDados(){
        this.minhaContaPage.getLinkEditarDados().click();
    }

    public void editaDadosUsuario(){
        wait.until(ExpectedConditions.visibilityOf(this.minhaContaPage.getTxtPrimeiroNome()));
        this.minhaContaPage.getTxtPrimeiroNome().sendKeys(dataGenerator.getFirstName());
        this.minhaContaPage.getTxtUltimoNome().sendKeys(dataGenerator.getLastName());
        this.minhaContaPage.getBtContinue().click();
    }

    public String retornaMensagem() {
        return this.minhaContaPage.getLblMensagemSucesso().getText();
    }
}

package br.com.application.name.web.funcionalidade;

import br.com.application.name.commons.BaseTest;
import br.com.application.name.web.pages.RegistroPage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistroFuncionalidade extends BaseTest {

    private RegistroPage registroPage;

    public RegistroFuncionalidade() {
        this.registroPage = new RegistroPage(webDriver);
    }

    public void preencheFormulario(){
        wait.until(ExpectedConditions.visibilityOf(this.registroPage.getInputFirstName()));
        this.registroPage.getInputFirstName().sendKeys(dataGenerator.getFirstName());
        this.registroPage.getInputLastName().sendKeys(dataGenerator.getLastName());
        this.registroPage.getInputEmail().sendKeys(dataGenerator.getEmail());
        this.registroPage.getInputTelephone().sendKeys(dataGenerator.getTelephone());
        this.registroPage.getInputPassword().sendKeys(dataGenerator.getPassword());
        this.registroPage.getInputConfirmPassword().sendKeys(dataGenerator.getConfirmPassword());
        addEvidenciaWeb("Formulário preenchido!");
    }

    public void confirmaRegistro(boolean aceitarPolitica){
        if (aceitarPolitica)
            this.registroPage.getCheckBoxPolicy().click();
        addEvidenciaWeb("Clicar em continuar.");
        this.registroPage.getBtnContinue().click();
    }
}

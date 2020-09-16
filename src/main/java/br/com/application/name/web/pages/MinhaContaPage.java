package br.com.application.name.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MinhaContaPage {

    public MinhaContaPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//a[text()='Edit your account information']")
    private WebElement linkEditarDados;

    @FindBy(id = "input-firstname")
    private WebElement txtPrimeiroNome;

    @FindBy(id = "input-lastname")
    private WebElement txtUltimoNome;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    private WebElement btContinue;

    @FindBy(xpath = "//i[@class='fa fa-check-circle']")
    private WebElement lblMensagemSucesso;

    public WebElement getLinkEditarDados() {
        return linkEditarDados;
    }

    public WebElement getTxtPrimeiroNome() {
        return txtPrimeiroNome;
    }

    public WebElement getTxtUltimoNome() {
        return txtUltimoNome;
    }

    public WebElement getBtContinue() {
        return btContinue;
    }

    public WebElement getLblMensagemSucesso() {
        return lblMensagemSucesso;
    }
}

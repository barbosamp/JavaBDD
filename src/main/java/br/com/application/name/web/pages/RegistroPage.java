package br.com.application.name.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistroPage {


    public RegistroPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "input-firstname")
    private WebElement inputFirstName;

    @FindBy(id = "input-lastname")
    private WebElement inputLastName;

    @FindBy(id = "input-email")
    private WebElement inputEmail;

    @FindBy(id = "input-telephone")
    private WebElement inputTelephone;

    @FindBy(id = "input-password")
    private WebElement inputPassword;

    @FindBy(id = "input-confirm")
    private WebElement inputConfirmPassword;

    @FindBy(xpath = "//input[@type='checkbox' and @name='agree']")
    private WebElement checkBoxPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement btnCriar;

    @FindBy(css = "#content > h1")
    private WebElement msgRegistro;


    public WebElement getInputFirstName() {
        return inputFirstName;
    }

    public WebElement getInputLastName() {
        return inputLastName;
    }

    public WebElement getInputEmail() {
        return inputEmail;
    }

    public WebElement getInputTelephone() {
        return inputTelephone;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getInputConfirmPassword() {
        return inputConfirmPassword;
    }

    public WebElement getCheckBoxPolicy() {
        return checkBoxPolicy;
    }

    public WebElement getBtnContinue() {
        return btnCriar;
    }

    public WebElement getMsgRegistro() {
        return msgRegistro;
    }
}

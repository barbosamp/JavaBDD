package br.com.application.name.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(xpath = "//ul[@class='list-inline']/descendant::a[@class='dropdown-toggle']")
    private WebElement btMyAccount;

    @FindBy(xpath = "//a[text()='Register']")
    private WebElement btRegister;

    @FindBy(xpath = "//a[text()='Your Store']")
    private WebElement lblLogoInicial;

    public WebElement getBtMyAccount() {
        return btMyAccount;
    }

    public WebElement getBtRegister() {
        return btRegister;
    }

    public WebElement getLblLogoInicial() {
        return lblLogoInicial;
    }
}

package br.com.application.name.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MinhaContaPage {

    public MinhaContaPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//div[@id='content' and child::h2[text()='My Account']]")
    private WebElement lblMyAccount;

    public WebElement getLblMyAccount() {
        return lblMyAccount;
    }
}

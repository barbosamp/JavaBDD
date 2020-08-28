package br.com.application.name.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "input-email")
    private WebElement emailAddress;

    @FindBy(id = "input-password")
    private WebElement password;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    private WebElement btLogin;

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getBtLogin() {
        return btLogin;
    }
}

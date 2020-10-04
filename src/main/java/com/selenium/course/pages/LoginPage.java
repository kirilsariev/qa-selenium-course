package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id="user-name")
    private WebElement usernameField;

    @FindBy(xpath="//input[@placeholder='Password']")
    private WebElement passwordField;

    @FindBy(className="btn_action")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public ProductListerPage login(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        return new ProductListerPage(driver);
    }
}

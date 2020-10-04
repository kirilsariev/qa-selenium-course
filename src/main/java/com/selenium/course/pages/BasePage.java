package com.selenium.course.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected <T> T executeOperationWithExplicitWait(long timeoutInSeconds, ExpectedCondition<T> expectedCondition, int implicitWait){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        turnOffImplicitWait(driver);
        T result = wait.until(expectedCondition);
        turnOnImplicitWait(driver, implicitWait);
        return result;
    }

    private static void turnOffImplicitWait(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    private static void turnOnImplicitWait(WebDriver driver, int implicitWait){
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
    }

}

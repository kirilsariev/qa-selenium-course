package com.selenium.course.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SampleTest {
    WebDriver driver = null;

    @BeforeTest
    public void setupDriver() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void executeSimpleTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.className("btn_action"));
        loginButton.click();

        Select productList = new Select(driver.findElement(By.className("product_sort_container")));
        Thread.sleep(1000);
        productList.selectByVisibleText("Price (low to high)");

        WebElement addToBasketButton = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']//ancestor::div[@class='inventory_item']//button"));
        addToBasketButton.click();

    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }

}

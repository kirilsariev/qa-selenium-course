package com.selenium.course.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvException;
import com.selenium.course.base.TestUtil;
import com.selenium.course.utils.CsvReader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginTests extends TestUtil {

    @DataProvider(name="login-data")
    public static Object[][] dataProviderHardCoded(){
        return new Object[][]{
                {"user1", "pass1"},
                {"user2", "pass2"},
                {"user3", "pass3"}
        };
    }

    @DataProvider(name="login-data-file")
    public static Object[][] dataProviderFromFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/login-data.csv");
    }

    @Test(dataProvider = "login-data-file", groups = {"login"})
    public void executeTest(String user, String pass) throws InterruptedException {

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys(user);

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys(pass);

        WebElement loginButton = driver.findElement(By.className("btn_action"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginButton);

        username.clear();
        password.clear();

        Thread.sleep(1000);

    }

}

package com.selenium.course.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.selenium.course.base.TestUtil;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.ProductListerPage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductTests extends TestUtil {

    @Test
    public void executeProductPriceTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProductListerPage productListerPage = loginPage.login("standard_user", "secret_sauce");

        productListerPage.waitUntilProductLabelIsVisible(getImplicitWait());

        Assert.assertTrue(productListerPage.isProductsLabelDisplayed());

        Reporter.log("Login is successful");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(productListerPage.isProductPriceCorrect("Sauce Labs Onesie", "$8.99"));

        Assert.assertTrue(productListerPage.isProductPriceCorrect("Sauce Labs Onesie", "$7.99"));

        productListerPage.clickOnProductByName("Sauce Labs Onesie");

        Thread.sleep(2000);
        softAssert.assertAll();
    }
}

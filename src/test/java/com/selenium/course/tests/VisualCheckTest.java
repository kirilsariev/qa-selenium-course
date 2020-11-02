package com.selenium.course.tests;

import com.selenium.course.base.TestUtil;
import com.selenium.course.pages.LoginPage;
import com.selenium.course.pages.ProductListerPage;
import com.selenium.course.utils.EyesManager;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VisualCheckTest extends TestUtil {
    EyesManager eyesManager;

    @BeforeTest
    public void initEyesManager(){
        eyesManager = new EyesManager(driver, "SWAGLABS", "IPp6EqCF5KhMnMR976W5GQPcyXGYuPVZpgkNoEcvb0hI110");
    }

    @Test
    public void executeProductPriceTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductListerPage productListerPage = loginPage.login("standard_user", "secret_sauce");

        productListerPage.waitUntilProductLabelIsVisible(getImplicitWait());

        Assert.assertTrue(productListerPage.isProductsLabelDisplayed());

        Reporter.log("Login is successful.");

//        productListerPage.clickOnProductByName("Sauce Labs Bike Light");
        productListerPage.clickOnProductByName("Sauce Labs Onesie");

        eyesManager.validateWindow();

    }
}

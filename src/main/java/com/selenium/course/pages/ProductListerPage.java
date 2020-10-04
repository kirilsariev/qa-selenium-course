package com.selenium.course.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductListerPage extends BasePage {
    private static final String PRODUCT_PRICE_BY_NAME_XPATH = "//div[@class = 'inventory_item_name' and text()='%s']//ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']";
    private static final String PRODUCT_BY_NAME_XPATH = "//div[@class = 'inventory_item_name' and text()='%s']";

    @FindBy(className = "product_label")
    private WebElement productsLabel;

    public ProductListerPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsLabelDisplayed() {
        return productsLabel.isDisplayed();
    }

    public void waitUntilProductLabelIsVisible(int implicitWait) {
        executeOperationWithExplicitWait(20, ExpectedConditions.visibilityOf(productsLabel), implicitWait);
    }

    public boolean isProductPriceCorrect(String productName, String expectedPrice) {
        String xpathFormatted = String.format(PRODUCT_PRICE_BY_NAME_XPATH, productName);
        WebElement priceElement = driver.findElement(By.xpath(xpathFormatted));
        log.info("price is: {}" + priceElement.getText());
        return priceElement.getText().equals(expectedPrice);
    }

    public void clickOnProductByName(String productName){
        String xpathFormatted = String.format(PRODUCT_BY_NAME_XPATH, productName);
        driver.findElement(By.xpath(xpathFormatted)).click();
    }
}

package com.selenium.pages;

import com.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSummaryPage extends BasePage {

    private final By successNotice = By.cssSelector(".woocommerce-notice");

    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }

    public String getNotice() {
        return driver.findElement(successNotice).getText();
    }



}


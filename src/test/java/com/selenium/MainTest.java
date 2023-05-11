package com.selenium;

import com.selenium.base.BaseTest;
import com.selenium.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class MainTest extends BaseTest {

    @Test
    void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {

        StorePage storePage = new HomePage(driver)
                .load()
                .navigateToStoreUsingMenu()
                .search("Blue");

        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
        storePage.clickAddToCart("Blue Shoes");
        Thread.sleep(3000);

        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage
                .enterFirstName("demo")
                .enterLastName("user")
                .enterAddress("Bronx")
                .enterCity("Krakow")
                .enterPostcode("30000")
                .enterEmail("sa@sa.sa");
        OrderSummaryPage summaryPage = checkoutPage.placeOrder();
        Thread.sleep(3000);

        Assertions.assertEquals(summaryPage.getNotice(), "Thank you. Your order has been received.");
    }

    @Test
    void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {
        driver.get("https://askomdch.com/");

        HomePage homePage = new HomePage(driver);

        StorePage storePage = homePage.navigateToStoreUsingMenu();
        storePage.search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
        storePage.clickAddToCart("Blue Shoes");
        Thread.sleep(3000);

        CartPage cartPage = storePage.clickViewCart();
        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");

        CheckoutPage checkoutPage = cartPage.checkout();
        checkoutPage.clickLoginCheckbox();
        Thread.sleep(3000);
        checkoutPage
                .enterLogin("dwadwa@dwa.dwa")
                .enterPassword("dwadwa@dwa.dwa")
                .login();
        Thread.sleep(3000);
        checkoutPage
                .enterFirstName("demo")
                .enterLastName("user")
                .enterAddress("Bronx")
                .enterCity("Krakow")
                .enterPostcode("30000")
                .enterEmail("sa@sa.sa");
        OrderSummaryPage summaryPage = checkoutPage.placeOrder();
        Thread.sleep(3000);

        Assertions.assertEquals(summaryPage.getNotice(), "Thank you. Your order has been received.");

    }
}

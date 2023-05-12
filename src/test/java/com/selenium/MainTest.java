package com.selenium;

import com.selenium.pom.base.BaseTest;
import com.selenium.pom.objects.BillingAddress;
import com.selenium.pom.objects.Product;
import com.selenium.pom.objects.User;
import com.selenium.pom.pages.*;
import com.selenium.pom.utils.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.IOException;

public class MainTest extends BaseTest {

    @Test
    void guestCheckoutUsingDirectBankTransfer() throws IOException {
        BillingAddress address = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        Product product = new Product(1215);
        String searchFor = "Blue";
        StorePage storePage = new HomePage(driver)
                .load()
                .navigateToStoreUsingMenu()
                .search(searchFor);

        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");
        storePage.addToCart(product.getName());

        CartPage cartPage = storePage.viewCart();
        Assert.assertEquals(cartPage.getProductName(), product.getName());

        CheckoutPage checkoutPage = cartPage.checkout()
                .setBillingAddress(address)
                .placeOrder();

        Assertions.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");
    }

    @Test
    void loginAndCheckoutUsingDirectBankTransfer() throws IOException {
        BillingAddress address = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        Product product = new Product(1215);
        User user = new User("dwadwadwad@sa.sa", "password123!");
        String searchFor = "Blue";
        StorePage storePage = new HomePage(driver)
                .load()
                .navigateToStoreUsingMenu()
                .search(searchFor);

        Assert.assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");
        storePage.addToCart(product.getName());

        CartPage cartPage = storePage.viewCart();
        Assert.assertEquals(cartPage.getProductName(), product.getName());

        CheckoutPage checkoutPage = cartPage
                .checkout()
                .clickLoginCheckbox()
                .login(user.getUsername(), user.getPassword())
                .setBillingAddress(address)
                .placeOrder();


        Assertions.assertEquals(checkoutPage.getNotice(), "Thank you. Your order has been received.");

    }
}

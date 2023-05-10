package com.selenium;

import com.selenium.pom.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MainTest extends BaseTest {

    @Test
    void guestCheckoutUsingDirectBankTransfer() throws InterruptedException {
        driver.get("https://askomdch.com/");
        driver.findElement(By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']")).click();
        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
        driver.findElement(By.cssSelector("button[value='Search']")).click();
        Assert.assertEquals(
                driver.findElement(By.cssSelector("h1.woocommerce-products-header__title.page-title")).getText(),
                "Search results: “Blue”");
        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='View cart']"))).click();

        Assert.assertEquals(
                driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(),
                "Blue Shoes"
        );
        driver.findElement(By.cssSelector(".checkout-button")).click();
        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
        driver.findElement(By.id("billing_last_name")).sendKeys("user");
        driver.findElement(By.id("billing_address_1")).sendKeys("Ulica");
        driver.findElement(By.id("billing_city")).sendKeys("Krk");
        driver.findElement(By.id("billing_postcode")).sendKeys("30000");
        driver.findElement(By.id("billing_email")).sendKeys("sa@sa.sa.sa");
        driver.findElement(By.id("place_order")).click();
        Thread.sleep(3000);
        Assertions.assertEquals(
                "Thank you. Your order has been received.",
                driver.findElement(By.cssSelector(".woocommerce-notice")).getText()
        );

    }
    @Test
    void loginAndCheckoutUsingDirectBankTransfer() throws InterruptedException {
        driver.get("https://askomdch.com/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']")).click();
        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
        driver.findElement(By.cssSelector("button[value='Search']")).click();
        Assert.assertEquals(
                driver.findElement(By.cssSelector("h1.woocommerce-products-header__title.page-title")).getText(),
                "Search results: “Blue”");
        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='View cart']"))).click();

        Assert.assertEquals(
                driver.findElement(By.cssSelector("td[class='product-name'] a")).getText(),
                "Blue Shoes"
        );
        driver.findElement(By.cssSelector(".checkout-button")).click();
        driver.findElement(By.className("showlogin")).click();
        driver.findElement(By.id("username")).sendKeys("dwadwa@dwa.dwa");
        driver.findElement(By.id("password")).sendKeys("dwadwa@dwa.dwa");
        driver.findElement(By.name("login")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("billing_first_name")).sendKeys("demo");
        driver.findElement(By.id("billing_last_name")).sendKeys("user");
        driver.findElement(By.id("billing_address_1")).sendKeys("Ulica");
        driver.findElement(By.id("billing_city")).sendKeys("Krk");
        driver.findElement(By.id("billing_postcode")).sendKeys("30000");
        driver.findElement(By.id("billing_email")).clear();
        driver.findElement(By.id("billing_email")).sendKeys("sa@sa.sa.sa");
        driver.findElement(By.id("place_order")).click();
        Thread.sleep(3000);
        Assertions.assertEquals(
                "Thank you. Your order has been received.",
                driver.findElement(By.cssSelector(".woocommerce-notice")).getText()
        );

    }
}

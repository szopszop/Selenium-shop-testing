package com.selenium.pages;

import com.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {

    private final By searchField = By.id("woocommerce-product-search-field-0");
    private final By searchButton = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector("h1.woocommerce-products-header__title.page-title");
    private final By viewCartLink = By.cssSelector("a[title='View cart']");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public StorePage search(String txt) {
        enterTextInSearchField(txt).clickSearchButton();
        return this;
    }

    private StorePage enterTextInSearchField(String txt) {
        driver.findElement(searchField).sendKeys(txt);
        return this;
    }

    private void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    private By getAddToCartButtonElement(String productName) {
        return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");

    }

    public void clickAddToCart(String productName) {
        By addToCartButton = getAddToCartButtonElement(productName);
        driver.findElement(addToCartButton).click();
    }

    public CartPage clickViewCart() {
        driver.findElement(viewCartLink).click();
        return new CartPage(driver);
    }



}

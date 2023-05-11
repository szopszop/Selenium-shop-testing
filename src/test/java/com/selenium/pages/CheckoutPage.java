package com.selenium.pages;

import com.selenium.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By firstNameField = By.id("billing_first_name");
    private final By lastNameField = By.id("billing_last_name");
    private final By addressField = By.id("billing_address_1");
    private final By cityField = By.id("billing_city");
    private final By postcodeField = By.id("billing_postcode");
    private final By emailField = By.id("billing_email");
    private final By placeOrderButton = By.id("place_order");
    private final By showLoginButton = By.className("showlogin");
    private final By loginField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.name("login");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterFirstName(String firstName) {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterAddress(String address) {
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);
        return this;
    }

    public CheckoutPage enterCity(String city) {
        driver.findElement(cityField).clear();
        driver.findElement(cityField).sendKeys(city);
        return this;
    }

    public CheckoutPage enterPostcode(String postcode) {
        driver.findElement(postcodeField).clear();
        driver.findElement(postcodeField).sendKeys(postcode);
        return this;
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public OrderSummaryPage placeOrder() {
        driver.findElement(placeOrderButton).click();
        return new OrderSummaryPage(driver);
    }

    public CheckoutPage clickLoginCheckbox() {
        driver.findElement(showLoginButton).click();
        return this;
    }

    public CheckoutPage enterLogin(String login) {
        driver.findElement(loginField).clear();
        driver.findElement(loginField).sendKeys(login);
        return this;
    }

    public CheckoutPage enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public void login() {
        driver.findElement(loginButton).click();
    }

}

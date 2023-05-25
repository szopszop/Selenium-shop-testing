package com.selenium.pom.pages;

import com.selenium.pom.base.BasePage;
import com.selenium.pom.objects.BillingAddress;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    private final By firstNameField = By.id("billing_first_name");
    private final By lastNameField = By.id("billing_last_name");
    private final By addressField = By.id("billing_address_1");
    private final By cityField = By.id("billing_city");
    private final By postalCodeField = By.id("billing_postcode");
    private final By emailField = By.id("billing_email");
    private final By placeOrderButton = By.id("place_order");
    private final By showLoginButton = By.className("showlogin");
    private final By loginField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.name("login");
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");
    private final By successNotice = By.cssSelector(".woocommerce-notice");
    private final By countryDropdown = By.id("select2-billing_country-container");
    private final By stateDropdown = By.id("select2-billing_state-container");
    private final By directBankTransfterRadioButton = By.id("payment_method_bacs");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        element.clear();
        element.sendKeys(lastName);
        return this;
    }

    public CheckoutPage selectCountry(String countryName) {
        wait.until(ExpectedConditions.elementToBeClickable(countryDropdown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                By .xpath("//li[text()='" + countryName + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", e);
        e.click();
        return this;
    }
    public CheckoutPage selectState (String stateName) {
        wait.until(ExpectedConditions.elementToBeClickable(stateDropdown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                By .xpath("//li[text()='" + stateName + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", e);
        e.click();
        return this;
    }

    public CheckoutPage enterAddress(String address) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(addressField));
        element.clear();
        element.sendKeys(address);
        return this;
    }

    public CheckoutPage enterCity(String city) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(cityField));
        element.clear();
        element.sendKeys(city);
        return this;
    }

    public CheckoutPage enterPostalCode(String postalCode) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField));
        element.clear();
        element.sendKeys(postalCode);
        return this;
    }

    public void enterEmail(String email) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        element.clear();
        element.sendKeys(email);
    }

    public CheckoutPage setBillingAddress(BillingAddress billingAddress) {
        enterFirstName(billingAddress.getFirstName())
                .enterLastName(billingAddress.getLastName())
                .selectCountry(billingAddress.getCountry())
                .enterAddress(billingAddress.getAddress())
                .selectState(billingAddress.getState())
                .enterCity(billingAddress.getCity())
                .enterPostalCode(billingAddress.getPostalCode())
                .enterEmail(billingAddress.getEmail());
        return this;
    }

    public CheckoutPage placeOrder() {
        waitForOverlaysToDisappear(overlay);
        driver.findElement(placeOrderButton).click();
        return this;
    }

    public CheckoutPage clickLoginCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(showLoginButton)).click();
        return this;
    }

    public void enterLogin(String login) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginField)).sendKeys(login);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public CheckoutPage login(String login, String password) {
        enterLogin(login);
        enterPassword(password);
        driver.findElement(loginButton).click();
        return this;

    }


    public String getNotice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successNotice)).getText();
    }


    public CheckoutPage selectDirectBankTransfer() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(directBankTransfterRadioButton));
        if (!element.isSelected()) {
            element.click();
        }
        return this;

    }

}

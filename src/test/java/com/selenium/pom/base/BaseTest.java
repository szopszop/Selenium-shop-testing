package com.selenium.pom.base;

import com.selenium.pom.factory.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void startDriver() {
        driver = new DriverManager().initializeDriver();
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }



}

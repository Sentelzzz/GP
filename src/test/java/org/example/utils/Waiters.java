package org.example.utils;

import org.example.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {

    /*protected static WebDriver driver = DriverSingleton.getInstance().getDriver();*/

    private Waiters() {
    }

    public static void waitClickElementToBeClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void waitVisibilityOf(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitElementToBeClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitVisibilityOfElementLocated(WebDriver driver, String locator, String label) {
        new WebDriverWait(driver, 20).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(String.format(locator, label))));
    }

    public static void waitVisibilityOfElementLocatedLocator(WebDriver driver, String locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(locator)));
    }

}

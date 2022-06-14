package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {

    private static final Integer WAITERS_TIME = 20;

    private Waiters() {
    }

    public static void waitClickElementToBeClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(WAITERS_TIME)).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void waitVisibilityOf(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(WAITERS_TIME)).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitElementToBeClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(WAITERS_TIME)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitVisibilityOfElementLocated(WebDriver driver, String locator, String label) {
        new WebDriverWait(driver, Duration.ofSeconds(WAITERS_TIME)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(String.format(locator, label))));
    }

    public static void waitVisibilityOfElementLocatedLocator(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(WAITERS_TIME)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(locator)));
    }

}

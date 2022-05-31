package org.example.elements;

import org.example.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewObjectButton extends BasePage {

    public NewObjectButton() {
    }

    private static final String NEW_OBJECT_BUTTON = "//div[@title='New']";

    public void createNewObject() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath(NEW_OBJECT_BUTTON)));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(NEW_OBJECT_BUTTON)));
    }
}

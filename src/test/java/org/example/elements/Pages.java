package org.example.elements;

import org.example.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Pages extends BasePage {

    private final String label;

    public Pages(String label) {
        this.label = label;
    }

    private static final String PAGES_XPATH = "//a[@title='%s']//span";

    public void openNextPage() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(PAGES_XPATH, label))));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(String.format(PAGES_XPATH, label))));
    }
}

package org.example.elements;

import org.example.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CaseStatus extends BasePage {

    private static final String CASE_STATUS = "//span[contains(text(), '%s')]//parent::a[contains(@role, 'option')]";

    public void changeCaseStatus(String status) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(String.format(CASE_STATUS, status))));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(String.format(CASE_STATUS, status))));
    }

    /*driver.findElement(By.xpath(String.format(CASE_STATUS, status))).click();*/
}

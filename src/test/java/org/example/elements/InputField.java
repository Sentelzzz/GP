package org.example.elements;

import org.example.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InputField extends BasePage {

    private final String label;

    public InputField(String label) {
        this.label = label;
    }

    private static final String INPUT_XPATH = "//span[contains(text(), '%s')]/ancestor::div[contains(@class, 'uiInput')]//input";

    public void writeText(String text) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
                .visibilityOf(driver.findElement(By.xpath(String.format(INPUT_XPATH, label))))).sendKeys(text);
    }
}

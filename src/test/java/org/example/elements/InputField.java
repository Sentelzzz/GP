package org.example.elements;

import org.example.page.BasePage;
import org.example.utils.Waiters;
import org.openqa.selenium.By;

public class InputField extends BasePage {

    private static final String INPUT_XPATH = "//span[contains(text(), '%s')]/ancestor::div[contains(@class, 'uiInput')]//input";

    private final String label;

    public InputField(String label) {
        this.label = label;
    }

    public void writeText(String text) {
        Waiters.waitVisibilityOfElementLocated(driver, INPUT_XPATH, label);
        driver.findElement(By.xpath(String.format(INPUT_XPATH, label))).sendKeys(text);
    }
}

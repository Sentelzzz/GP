package org.example.elements;

import org.example.page.BasePage;
import org.example.utils.JavaExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Pages extends BasePage {

    private static final String PAGES_XPATH = "//a[@title='%s']//span";

    private final String label;

    public Pages(String label) {
        this.label = label;
    }

    public void openNextPage() {
        new WebDriverWait(driver, 20).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(String.format(PAGES_XPATH, label))));
        JavaExecutor.javaExecutor(driver, driver.findElement(By.xpath(String.format(PAGES_XPATH, label))));
    }
}

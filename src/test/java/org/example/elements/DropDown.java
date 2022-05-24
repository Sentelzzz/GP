package org.example.elements;

import org.example.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropDown extends BasePage {

    private String label;

    public DropDown(String label) {
        this.label = label;
    }

    private static final String DROP_DOWN_XPATH = "//*[contains(text(),'%s')]/ancestor::div[contains(@class,'uiInput')]//a";
    private static final String SELECT_OPTION_XPATH = "//*[@class='select-options']/descendant::a[contains(text(),'%s')]";

    public void selectOption(String option) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
                .visibilityOf(driver.findElement(By.xpath(String.format(DROP_DOWN_XPATH, label))))).click();
        driver.findElement(By.xpath(String.format(SELECT_OPTION_XPATH, option))).click();
    }
}

package org.example.elements;

import org.example.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountName extends BasePage {

    private String label;

    public AccountName(String label) {
        this.label = label;
    }

    private final static String ACCOUNT_NAME_XPATH = "//span[contains(text(), 'Account')]/ancestor::" +
            "li[contains(@class, 'slds')]//span[contains(@class, 'entity')]//lightning-base-combobox-formatted-text[@title='%s']";

    public void choseAccount(){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(String.format(ACCOUNT_NAME_XPATH, label))));
        driver.findElement(By.xpath(String.format(ACCOUNT_NAME_XPATH, label))).click();
    }
}

package org.example.elements;

import org.example.page.BasePage;
import org.example.utils.Waiters;
import org.openqa.selenium.By;

public class AccountName extends BasePage {

    private final static String ACCOUNT_NAME_XPATH = "//span[contains(text(), 'Account')]/ancestor::" +
            "li[contains(@class, 'slds')]//span[contains(@class, 'entity')]//lightning-base-combobox-formatted-text[@title='%s']";

    private final String label;

    public AccountName(String label) {
        this.label = label;
    }

    public void choseAccount(){
        Waiters.waitVisibilityOfElementLocated(driver, ACCOUNT_NAME_XPATH, label);
        driver.findElement(By.xpath(String.format(ACCOUNT_NAME_XPATH, label))).click();
    }
}

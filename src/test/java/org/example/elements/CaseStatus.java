package org.example.elements;

import org.example.page.BasePage;
import org.example.utils.JavaExecutor;
import org.example.utils.Waiters;
import org.openqa.selenium.By;

public class CaseStatus extends BasePage {

    private static final String CASE_STATUS = "//span[contains(text(), '%s')]//parent::a[contains(@role, 'option')]";

    public void changeCaseStatus(String status) {
        Waiters.waitVisibilityOfElementLocated(driver, CASE_STATUS, status);
        JavaExecutor.javaExecutor(driver, driver.findElement(By.xpath(String.format(CASE_STATUS, status))));
    }

}

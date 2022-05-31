package org.example.elements;

import org.example.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropDown extends BasePage {

    private String label;

    public DropDown(String label) {
        this.label = label;
    }

    public DropDown() {
    }

    private static final String DROP_DOWN_XPATH = "//*[contains(text(),'%s')]/ancestor::div[contains(@class,'uiInput')]//a";
    private static final String SELECT_OPTION_XPATH = "//*[@class='select-options']/descendant::a[contains(text(),'%s')]";

    private static final String SELECT_LEAD_STATUS_XPATH = "//label[contains(text(), 'Lead Status')]//following-sibling::div//span[contains(text(), '%s')]";

    private static final String SELECT_CASE_DROP_DOWN = "//span[contains(text(), '%s')]//parent::span[contains(@class, 'label')]//following-sibling::div/*//a[contains(text(), '--None--')]";
    private static final String SELECT_CASE_DROP_DOWN_OPTION = "//div[@role='menu']/*//a[contains(text(), '%s')]";

    private static final String SELECT_EVENT_SUBJECT_OPTION = "//span[contains(text(), '%s')]//ancestor::lightning-base-combobox-item";

    public void selectOption(String option) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(String.format(DROP_DOWN_XPATH, label)))).click();
        driver.findElement(By.xpath(String.format(SELECT_OPTION_XPATH, option))).click();
    }

    public void selectLeadStatus(String option) {
        driver.findElement(By.xpath(String.format(SELECT_LEAD_STATUS_XPATH, option))).click();
    }

    public void selectCaseDropDown() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
                    .visibilityOfElementLocated((By.xpath(String.format(SELECT_CASE_DROP_DOWN, label)))));
        } catch (TimeoutException e) {
            System.out.println("You cant use this element!");
        }
        driver.findElement(By.xpath(String.format(SELECT_CASE_DROP_DOWN, label))).click();
    }

    public void selectCaseDropDownOption() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
                .elementToBeClickable(driver.findElement(By.xpath(String.format(SELECT_CASE_DROP_DOWN_OPTION, label))))).click();
    }

    public void selectEventSubject(String subject) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
                .elementToBeClickable(driver.findElement(By.xpath(String.format(SELECT_EVENT_SUBJECT_OPTION, subject))))).click();
    }
}

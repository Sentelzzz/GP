package org.example.elements;

import org.example.page.BasePage;
import org.example.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteCreatedObjects extends BasePage {

    private static final String CREATED_OBJECT_XPATH = "//th[@scope='row']/*//a";
    private static final String DROP_DOWN_XPATH = "//li[contains(@class, 'dropdown')]/*/button[@class='slds-button slds-button_icon-border-filled']";
    private static final String DELETE_OPTION_XPATH = "//div[@class='slds-dropdown slds-dropdown_right']//div/*/*[@apiname='Delete']";
    private static final String DELETE_BUTTON = "//button[@title='Delete']//span[contains(text(), 'Delete')]";

    public void deleteObject() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CREATED_OBJECT_XPATH))).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DROP_DOWN_XPATH))).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DELETE_OPTION_XPATH))).click();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(DELETE_BUTTON))).click();
    }
}

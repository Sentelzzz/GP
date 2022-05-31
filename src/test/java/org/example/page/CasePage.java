package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.elements.CaseStatus;
import org.example.elements.DeleteCreatedObjects;
import org.example.elements.DropDown;
import org.example.elements.NewObjectButton;
import org.example.utils.Waters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CasePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(CasePage.class);

    @FindBy(xpath = "//span[contains(text(), 'Save')]//parent::button[@title='Save']")
    private WebElement saveButton;

    public void saveNewCase() {
        saveButton.click();
    }

    @FindBy(xpath = "//a[contains(text(), 'Case Details')]")
    private WebElement casePageName;

    public String getTextPageName() {
        logger.atInfo().log("Get name of created page");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(casePageName));
        return casePageName.getText();
    }

    @FindBy(xpath = "//span[contains(text(), 'Mark as Current Status')]")
    private WebElement confirmChangingSpan;

    public void confirmNewCaseStatus() {
        logger.atInfo().log("Confirm new case status");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(confirmChangingSpan));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", confirmChangingSpan);
    }

    @FindBy(xpath = "//span[contains(text(), 'Status')]//parent::p")
    private WebElement currentStatusSpan;

    public String getTextCurrentStatus() {
        logger.atInfo().log("Get text current status");
        return currentStatusSpan.getText();
    }

    public CasePage clickOnSelect(String status) {
        logger.atInfo().log("Choose dropdown field");
        try {
            new DropDown(status).selectCaseDropDown();
        } catch (NoSuchElementException exception) {
            System.out.println("You cant use this element!");
        }
        return this;
    }

    public CasePage choseCaseOption(String dropDownName) {
        logger.atInfo().log("Choose option this dropdown");
        new DropDown(dropDownName).selectCaseDropDownOption();
        return this;
    }

    public CasePage clickCreateNewCaseButton() {
        logger.atInfo().log("Click on create new case button");
        new NewObjectButton().createNewObject();
        return this;
    }

    public CasePage changeCurrentCaseStatus(String status) {
        logger.atInfo().log("Change status");
        new CaseStatus().changeCaseStatus(status);
        return this;
    }

    public CasePage openCreatedCase() {
        logger.atInfo().log("Go to cases page");
        new DeleteCreatedObjects().openCreatedProject();
        return this;
    }
}

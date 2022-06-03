package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.elements.*;
import org.example.utils.JavaExecutor;
import org.example.utils.Waiters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CasePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(CasePage.class);

    @FindBy(xpath = "//a[contains(text(), 'Case Details')]")
    private WebElement casePageName;

    @FindBy(xpath = "//span[contains(text(), 'Mark as Current Status')]")
    private WebElement confirmChangingSpan;

    @FindBy(xpath = "//span[contains(text(), 'Status')]//parent::p")
    private WebElement currentStatusSpan;

    public String getTextPageName() {
        logger.atInfo().log("Get name of created page");
        Waiters.waitVisibilityOf(driver, casePageName);
        return casePageName.getText();
    }

    public void confirmNewCaseStatus() {
        logger.atInfo().log("Confirm new case status");
        Waiters.waitElementToBeClickable(driver, confirmChangingSpan);
        JavaExecutor.javaExecutor(driver, confirmChangingSpan);
    }

    public String getTextCurrentStatus() {
        logger.atInfo().log("Get text current status");
        return currentStatusSpan.getText();
    }

    public CasePage clickOnSelect(String status) {
        logger.atInfo().log("Choose dropdown field");
        new DropDown(status).selectCaseDropDown();
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

    public void clickSaveButton() {
        logger.atInfo().log("Save created case");
        new SaveButtonForCreatedObjects().clickSaveButton();
    }

}

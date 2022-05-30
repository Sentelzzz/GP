package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.elements.DeleteCreatedObjects;
import org.example.elements.DropDown;
import org.example.models.Leads;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LeadsPage extends BasePage{

    private static final Logger logger = LogManager.getLogger(LeadsPage.class);

    @FindBy(xpath = "//div[@title='New']")
    private WebElement buttonCreateNewLeadDiv;

    public LeadsPage clickCreateNewLeadButton() {
        logger.atInfo().log("Click on create new lead button");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(buttonCreateNewLeadDiv));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", buttonCreateNewLeadDiv);
        return this;
    }

    @FindBy(xpath = "//label[contains(text(), 'Last Name')]//following-sibling::div//input[@type='text']")
    private WebElement lastNameInputLabel;

    public LeadsPage fillLastNameField(Leads leads) {
        logger.atInfo().log("Fill out new lead last name");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(lastNameInputLabel));
        lastNameInputLabel.sendKeys(leads.getLastName());
        return this;
    }

    @FindBy(xpath = "//label[contains(text(), 'Company')]//following-sibling::div//input[@type='text']")
    private WebElement companyInputLabel;

    public LeadsPage fillCompanyField(Leads leads) {
        logger.atInfo().log("Fill out new lead last name");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(companyInputLabel));
        companyInputLabel.sendKeys(leads.getCompany());
        return this;
    }

    @FindBy(xpath = "//label[contains(text(),'Lead Status')]//following-sibling::div")
    private WebElement leadStatusDropDownLabel;

    public LeadsPage choseLeadStatus(Leads leads) {
        logger.atInfo().log("Chose the lead status");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(leadStatusDropDownLabel));
        leadStatusDropDownLabel.click();
        new DropDown().selectLeadStatus(leads.getLeadStatus());
        return this;
    }

    @FindBy(xpath = "//button[@name='SaveEdit']")
    private WebElement saveButton;

    public void clickOnSaveButton() {
        logger.atInfo().log("Save new lead");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }

    @FindBy(xpath = "//span[contains(text(), 'Name')]//parent::div//following-sibling::div//span//slot[@name='outputField']//lightning-formatted-name")
    private WebElement nameLeadPageSpan;

    public String getActualTextNameOfLeadPage() {
        logger.atInfo().log("Get name of created lead");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(nameLeadPageSpan));
        return nameLeadPageSpan.getText();
    }

    @FindBy(xpath = "//div[@class='slds-media__body']//h2[@title='We hit a snag.']")
    private WebElement errorMessageDiv;

    public String getErrorMessage() {
        return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(errorMessageDiv)).getText();
    }

    public void deleteCreatedLead() {
        new DeleteCreatedObjects().deleteObject();
    }

}

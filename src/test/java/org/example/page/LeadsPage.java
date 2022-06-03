package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.elements.DeleteCreatedObjects;
import org.example.elements.DropDown;
import org.example.elements.NewObjectButton;
import org.example.elements.SaveButtonForCreatedObjects;
import org.example.models.Leads;
import org.example.utils.Waiters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadsPage extends BasePage{

    private static final Logger logger = LogManager.getLogger(LeadsPage.class);

    @FindBy(xpath = "//label[contains(text(), 'Last Name')]//following-sibling::div//input[@type='text']")
    private WebElement lastNameInputLabel;

    @FindBy(xpath = "//label[contains(text(), 'Company')]//following-sibling::div//input[@type='text']")
    private WebElement companyInputLabel;

    @FindBy(xpath = "//label[contains(text(),'Lead Status')]//following-sibling::div")
    private WebElement leadStatusDropDownLabel;

    @FindBy(xpath = "//span[contains(text(), 'Name')]//parent::div//following-sibling::div//span//slot[@name='outputField']//lightning-formatted-name")
    private WebElement nameLeadPageSpan;

    @FindBy(xpath = "//div[@class='slds-media__body']//h2[@title='We hit a snag.']")
    private WebElement errorMessageDiv;

    public LeadsPage fillLastNameField(Leads leads) {
        logger.atInfo().log("Fill out new lead last name");
        Waiters.waitVisibilityOf(driver, lastNameInputLabel);
        lastNameInputLabel.sendKeys(leads.getLastName());
        return this;
    }

    public LeadsPage fillCompanyField(Leads leads) {
        logger.atInfo().log("Fill out new lead last name");
        Waiters.waitVisibilityOf(driver, companyInputLabel);
        companyInputLabel.sendKeys(leads.getCompany());
        return this;
    }

    public LeadsPage choseLeadStatus(Leads leads) {
        logger.atInfo().log("Chose the lead status");
        Waiters.waitVisibilityOf(driver, leadStatusDropDownLabel);
        leadStatusDropDownLabel.click();
        new DropDown().selectLeadStatus(leads.getLeadStatus());
        return this;
    }

    public String getActualTextNameOfLeadPage() {
        logger.atInfo().log("Get name of created lead");
        Waiters.waitVisibilityOf(driver, nameLeadPageSpan);
        return nameLeadPageSpan.getText();
    }

    public String getErrorMessage() {
        Waiters.waitVisibilityOf(driver, errorMessageDiv);
        return errorMessageDiv.getText();
    }

    public void deleteCreatedLead() {
        logger.atInfo().log("Delete created object");
        new DeleteCreatedObjects().deleteObject();
    }

    public LeadsPage clickCreateNewLeadButton() {
        logger.atInfo().log("Click on create new lead button");
        new NewObjectButton().createNewObject();
        return this;
    }

    public void clickSaveButton() {
        logger.atInfo().log("Save created lead");
        new SaveButtonForCreatedObjects().clickSaveLeadContactButton();
    }

}

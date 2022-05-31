package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.elements.AccountName;
import org.example.elements.DeleteCreatedObjects;
import org.example.elements.NewObjectButton;
import org.example.models.Account;
import org.example.models.Contact;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(ContactPage.class);

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameInput;

    public ContactPage fillLastNameField(Contact contact) {
        logger.atInfo().log("Fill out new contact first name");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
                .elementToBeClickable(lastNameInput)).sendKeys(contact.getLastName());
        return this;
    }

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameInput;

    public ContactPage fillFirstNameField(Contact contact) {
        logger.atInfo().log("Fill out new contact first name");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
                .elementToBeClickable(firstNameInput)).sendKeys(contact.getFirstName());
        return this;
    }

    @FindBy(xpath = "//label[contains(text(), 'Account Name')]/following-sibling::div//input")
    private WebElement accountNameInput;

    public ContactPage fillAccountNameField(Account account) {
        logger.atInfo().log("Fill out account name field");
        accountNameInput.sendKeys(account.getAccountName());
        return this;
    }

    @FindBy(xpath = "//button[@name='SaveEdit']")
    private WebElement saveNewContactButton;

    public void clickSaveNewContactButton() {
        logger.atInfo().log("Save new contact");
        saveNewContactButton.click();
    }

    @FindBy (xpath = "//div[contains(text(), 'Contact')]/parent::h1//div[contains(@class, 'testonly')]//span[contains(@class, 'custom')]")
    private WebElement nameNewContactSpan;

    public String getTextNameNewCreatedContact() {
        return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(nameNewContactSpan)).getText();
    }

    @FindBy(xpath = "//div[@class='slds-media__body']//h2[@title='We hit a snag.']")
    private WebElement errorMessageDiv;

    public String getErrorMessage() {
        return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(errorMessageDiv)).getText();
    }

    public ContactPage choseAccount(Account account) {
        new AccountName(account.getAccountName()).choseAccount();
        return this;
    }

    public ContactPage clickCreateNewAccountButton() {
        logger.atInfo().log("Click on create new account button");
        new NewObjectButton().createNewObject();
        return this;
    }

    public void deleteCreatedContact() {
        new DeleteCreatedObjects().deleteObject();
    }

    /*@FindBy(xpath = "//span[contains(text(), 'Account')]/ancestor::" +
            "li[contains(@class, 'slds')]//span[contains(@class, 'entity')]//lightning-base-combobox-formatted-text[@title='TMS']")
    private WebElement accountForNewContactSpan;*/

    /*public ContactPage choseAccountForContact() {
        logger.atInfo().log("Choose one of all existing accounts");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(accountForNewContactSpan));
        accountForNewContactSpan.click();
        return this;
    }*/
}

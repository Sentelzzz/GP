package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.elements.AccountName;
import org.example.elements.DeleteCreatedObjects;
import org.example.elements.NewObjectButton;
import org.example.elements.SaveButtonForCreatedObjects;
import org.example.models.Account;
import org.example.models.Contact;
import org.example.utils.Waiters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(ContactPage.class);

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//label[contains(text(), 'Account Name')]/following-sibling::div//input")
    private WebElement accountNameInput;

    @FindBy (xpath = "//div[contains(text(), 'Contact')]/parent::h1//div[contains(@class, 'testonly')]//span[contains(@class, 'custom')]")
    private WebElement nameNewContactSpan;

    @FindBy(xpath = "//div[@class='slds-media__body']//h2[@title='We hit a snag.']")
    private WebElement errorMessageDiv;

    public ContactPage fillLastNameField(Contact contact) {
        logger.atInfo().log("Fill out new contact first name");
        Waiters.waitElementToBeClickable(driver, lastNameInput);
        lastNameInput.sendKeys(contact.getLastName());
        return this;
    }

    public ContactPage fillFirstNameField(Contact contact) {
        logger.atInfo().log("Fill out new contact first name");
        Waiters.waitElementToBeClickable(driver, firstNameInput);
        firstNameInput.sendKeys(contact.getFirstName());
        return this;
    }

    public ContactPage fillAccountNameField(Account account) {
        logger.atInfo().log("Fill out account name field");
        accountNameInput.sendKeys(account.getAccountName());
        return this;
    }

    public String getTextNameNewCreatedContact() {
        Waiters.waitVisibilityOf(driver, nameNewContactSpan);
        return nameNewContactSpan.getText();
    }

    public String getErrorMessage() {
        Waiters.waitVisibilityOf(driver, errorMessageDiv);
        return errorMessageDiv.getText();
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
        logger.atInfo().log("Delete created contact");
        new DeleteCreatedObjects().deleteObject();
    }

    public void clickSaveButton() {
        logger.atInfo().log("Save created contact");
        new SaveButtonForCreatedObjects().clickSaveLeadContactButton();
    }

}

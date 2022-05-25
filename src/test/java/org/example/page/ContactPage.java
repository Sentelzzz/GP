package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    @FindBy(xpath = "//div[contains(text(), 'New')]")
    private WebElement createNewContactButtonDiv;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//label[contains(text(), 'Account Name')]/following-sibling::div//input")
    private WebElement accountNameInput;

    @FindBy(xpath = "//button[@name='SaveEdit']")
    private WebElement saveNewContactButton;

    @FindBy(xpath = "//span[contains(text(), 'Account')]/ancestor::" +
            "li[contains(@class, 'slds')]//span[contains(@class, 'entity')]//lightning-base-combobox-formatted-text[@title='TMS']")
    private WebElement accountForNewContactSpan;

    @FindBy (xpath = "//div[contains(text(), 'Contact')]/parent::h1//div[contains(@class, 'testonly')]//span[contains(@class, 'custom')]")
    private WebElement nameNewContactSpan;

    @FindBy(xpath = "//div[@class='slds-media__body']//h2[@title='We hit a snag.']")
    private WebElement errorMessageDiv;

    @FindBy(xpath = "//th[@scope='row']/*//a")
    private WebElement contactLink;

    @FindBy(xpath = "//li[contains(@class, 'dropdown')]/*/button[@class='slds-button slds-button_icon-border-filled']")
    private WebElement dropDownAccountList;

    @FindBy(xpath = "//div[@class='slds-dropdown slds-dropdown_right']//div/*/*[@apiname='Delete']")
    private WebElement optionsDropDownAccountDiv;

    @FindBy(xpath = "//button[@title='Delete']//span[contains(text(), 'Delete')]")
    private WebElement deleteButton;

    public void deleteAccount() {
        logger.atInfo().log("Delete created account");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(deleteButton)).click();
    }

    public ContactPage choseDeleteOptionDropDown() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(optionsDropDownAccountDiv)).click();
        return this;
    }

    public ContactPage openDropDownContact() {
        logger.atInfo().log("Open drop down menu");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(dropDownAccountList));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", dropDownAccountList);
        return this;
    }

    public ContactPage openContactPage() {
        logger.atInfo().log("Open created contact");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(contactLink));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", contactLink);
        return this;
    }

    public String getErrorMessage() {
        return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(errorMessageDiv)).getText();
    }

    public String getTextNameNewCreatedContact() {
        return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(nameNewContactSpan)).getText();
    }

    public ContactPage choseAccountForContact() {
        logger.atInfo().log("Choose one of all existing accounts");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(accountForNewContactSpan));
        accountForNewContactSpan.click();
        return this;
    }

    /*public ContactPage choseAccount(Account account) {
        new AccountName().choseAccount(account.getAccountName());  //doesn't work with %s
        return this;
    }*/

    public void clickSaveNewContactButton() {
        logger.atInfo().log("Save new contact");
        saveNewContactButton.click();
    }

    public ContactPage fillAccountNameField(Account account) {
        logger.atInfo().log("Fill out account name field");
        accountNameInput.sendKeys(account.getAccountName());
        return this;
    }

    public ContactPage fillFirstNameField(Contact contact) {
        logger.atInfo().log("Fill out new contact first name");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
                .elementToBeClickable(firstNameInput)).sendKeys(contact.getFirstName());
        return this;
    }

    public ContactPage fillLastNameField(Contact contact) {
        logger.atInfo().log("Fill out new contact first name");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
                .elementToBeClickable(lastNameInput)).sendKeys(contact.getLastName());
        return this;
    }

    public ContactPage clickCreateNewAccountButton() {
        logger.atInfo().log("Click on create new account button");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(createNewContactButtonDiv));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", createNewContactButtonDiv);
        return this;
    }
}

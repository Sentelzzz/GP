package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.elements.DropDown;
import org.example.elements.InputField;
import org.example.models.Account;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.utils.StringConstants.*;

public class AccountPage extends BasePage{

    private static final Logger logger = LogManager.getLogger(AccountPage.class);

    @FindBy(xpath = "//div[@title='New']")
    private WebElement createNewAccountButtonDiv;

    @FindBy(xpath = "//button[@title = 'Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//span[contains(text(), 'Account Name')]/ancestor::div[contains(@class, 'uiInput')]//input")
    private WebElement accountNameFieldSpan;

    @FindBy (xpath = "//span[contains(text(), 'Account Name')]/parent::div/following-sibling::div//span//slot/lightning-formatted-text")
    private WebElement nameOfAccount;

    @FindBy(xpath = "//div[@class='slds-dropdown slds-dropdown_right']//div/*/*[@apiname='Delete']")
    private WebElement optionsDropDownAccountDiv;

    @FindBy(xpath = "//li[contains(@class, 'dropdown')]/*/button[@class='slds-button slds-button_icon-border-filled']")
    private WebElement dropDownAccountList;

    @FindBy(xpath = "//a[@data-refid='recordId']")
    private WebElement accountLink;

    @FindBy(xpath = "//button[@title='Delete']//span[contains(text(), 'Delete')]")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[contains(text(), 'Review the errors on this page.')]")
    private WebElement errorCreatingMessageSpan;

    public String getTextErrorMessageCreatingAccount() {
        return errorCreatingMessageSpan.getText();
    }

    public void deleteAccount() {
        logger.atInfo().log("Delete created account");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(deleteButton)).click();
    }

    public AccountPage openAccountPage() {
        logger.atInfo().log("Open created account");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(accountLink));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", accountLink);
        return this;
    }

    public AccountPage openDropDownAccount() {
        logger.atInfo().log("Open drop down menu");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(dropDownAccountList));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", dropDownAccountList);
        return this;
    }

    public AccountPage choseDeleteOptionDropDown() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(optionsDropDownAccountDiv)).click();
        return this;
    }

    public String getTextOfNameOfAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(nameOfAccount));
        return nameOfAccount.getText();
    }

    public void clickSaveButton() {
        logger.atInfo().log("Save new account");
        saveButton.click();
    }

    public AccountPage clickCreateNewAccountButton() {
        logger.atInfo().log("Click on create new account button");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(createNewAccountButtonDiv));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", createNewAccountButtonDiv);
        return this;
    }

    public AccountPage fillAccountField(Account account) {
        logger.atInfo().log("Fill out new account name");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
                .elementToBeClickable(accountNameFieldSpan)).sendKeys(account.getAccountName());
        return this;
    }

    public AccountPage fillWebSiteField(Account account) {
        logger.atInfo().log("Fill out new account webSite");
        new InputField(WEB_SITE_FIELD).writeText(account.getWebSite());
        return this;
    }

    public AccountPage choseIndustryType(Account account) {
        logger.atInfo().log("Chose new account industry");
        new DropDown(INDUSTRY_FIELD).selectOption(account.getIndustry());
        return this;
    }


}

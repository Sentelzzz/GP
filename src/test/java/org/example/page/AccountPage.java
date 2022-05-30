package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.elements.DeleteCreatedObjects;
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

    public AccountPage clickCreateNewAccountButton() {
        logger.atInfo().log("Click on create new account button");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(createNewAccountButtonDiv));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", createNewAccountButtonDiv);
        return this;
    }

    @FindBy(xpath = "//button[@title = 'Save']")
    private WebElement saveButton;

    public void clickSaveButton() {
        logger.atInfo().log("Save new account");
        saveButton.click();
    }

    @FindBy(xpath = "//span[contains(text(), 'Account Name')]/ancestor::div[contains(@class, 'uiInput')]//input")
    private WebElement accountNameFieldSpan;

    public AccountPage fillAccountField(Account account) {
        logger.atInfo().log("Fill out new account name");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions
                .elementToBeClickable(accountNameFieldSpan)).sendKeys(account.getAccountName());
        return this;
    }

    @FindBy (xpath = "//span[contains(text(), 'Account Name')]/parent::div/following-sibling::div//span//slot/lightning-formatted-text")
    private WebElement nameOfAccount;

    public String getTextOfNameOfAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(nameOfAccount));
        return nameOfAccount.getText();
    }

    @FindBy(xpath = "//span[contains(text(), 'Review the errors on this page.')]")
    private WebElement errorCreatingMessageSpan;

    public String getTextErrorMessageCreatingAccount() {
        return errorCreatingMessageSpan.getText();
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

    public void deleteCreatedAccount() {
        new DeleteCreatedObjects().deleteObject();
    }

}

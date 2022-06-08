package org.example.page;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.elements.*;
import org.example.models.Account;
import org.example.utils.AllureUtils;
import org.example.utils.Waiters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.example.utils.StringConstants.*;

public class AccountPage extends BasePage{

    private static final Logger logger = LogManager.getLogger(AccountPage.class);

    @FindBy(xpath = "//span[contains(text(), 'Account Name')]/ancestor::div[contains(@class, 'uiInput')]//input")
    private WebElement accountNameFieldSpan;

    @FindBy (xpath = "//span[contains(text(), 'Account Name')]/parent::div/following-sibling::div//span//slot/lightning-formatted-text")
    private WebElement nameOfAccount;

    @FindBy(xpath = "//span[contains(text(), 'Review the errors on this page.')]")
    private WebElement errorCreatingMessageSpan;

    @Step("Fill out new account name")
    public AccountPage fillAccountField(Account account) {
        logger.atInfo().log("Fill out new account name");
        Waiters.waitElementToBeClickable(driver, accountNameFieldSpan);
        accountNameFieldSpan.sendKeys(account.getAccountName());
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    public String getTextOfNameOfAccount() {
        Waiters.waitVisibilityOf(driver, nameOfAccount);
        return nameOfAccount.getText();
    }

    public String getTextErrorMessageCreatingAccount() {
        return errorCreatingMessageSpan.getText();
    }

    @Step("Fill out new account webSite")
    public AccountPage fillWebSiteField(Account account) {
        logger.atInfo().log("Fill out new account webSite");
        new InputField(WEB_SITE_FIELD).writeText(account.getWebSite());
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Chose new account industry")
    public AccountPage choseIndustryType(Account account) {
        logger.atInfo().log("Chose new account industry");
        new DropDown(INDUSTRY_FIELD).selectOption(account.getIndustry());
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    public void deleteCreatedAccount() {
        logger.atInfo().log("Delete created account");
        new DeleteCreatedObjects().deleteObject();
    }

    @Step("Click on create new account button")
    public AccountPage clickCreateNewAccountButton() {
        logger.atInfo().log("Click on create new account button");
        new NewObjectButton().createNewObject();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    public void clickSaveButton() {
        logger.atInfo().log("Save created account");
        new SaveButtonForCreatedObjects().clickSaveButton();
    }

}

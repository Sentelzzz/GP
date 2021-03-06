package org.example.page;

import io.qameta.allure.Step;
import org.example.utils.AllureUtils;
import org.example.utils.JsonParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;

public class LoginPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameFieldInput;

    @FindBy(xpath = "//input[@name='pw']")
    private WebElement passwordFieldInput;

    @FindBy(xpath = "//input[@name='Login']")
    private WebElement loginButtonInput;

    @FindBy(xpath = "//div[@id='error']")
    private WebElement errorMessageDiv;

    @Step("Enter username information")
    public LoginPage fillUsernameField(String username) throws IOException, ParseException {
        usernameFieldInput.clear();
        usernameFieldInput.sendKeys(JsonParser.parser(username));
        logger.atInfo().log("Enter username information");
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Enter password information")
    public LoginPage fillPasswordField(String password) throws IOException, ParseException {
        passwordFieldInput.clear();
        passwordFieldInput.sendKeys(JsonParser.parser(password));
        logger.atInfo().log("Enter password information");
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    public void clickLoginButton() {
        loginButtonInput.click();
        logger.atInfo().log("Click on login button after filling username and password fields");
    }

    public String getTextErrorMessage() {
        logger.atInfo().log("Get text of error message");
        return errorMessageDiv.getText();
    }

    @Step("Open login page")
    public LoginPage openPage(String url) {
        driver.get(url);
        logger.atInfo().log("Take url of start page to driver");
        AllureUtils.takeScreenshot(driver);
        return this;
    }

}

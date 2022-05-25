package org.example.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

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

    public String getTextErrorMessage() {
        logger.atInfo().log("Get text of error message");
        return errorMessageDiv.getText();
    }

    public LoginPage openPage(String url) {
        driver.get(url);
        logger.atInfo().log("Take url of start page to driver");
        return this;
    }

    public LoginPage fillUsernameField(String username) {
        usernameFieldInput.clear();
        usernameFieldInput.sendKeys(username);
        logger.atInfo().log("Enter username information");
        return this;
    }

    public LoginPage fillPasswordField(String password) {
        passwordFieldInput.clear();
        passwordFieldInput.sendKeys(password);
        logger.atInfo().log("Enter password information");
        return this;
    }

    public void clickLoginButton() {
        loginButtonInput.click();
        logger.atInfo().log("Click on login button after filling username and password fields");
    }
}

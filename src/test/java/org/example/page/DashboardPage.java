package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.utils.Waiters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(DashboardPage.class);

    @FindBy(xpath = "//div[@title='New Dashboard']")
    private WebElement newDashboardButtonDiv;

    @FindBy(xpath = "//input[@id='dashboardNameInput']")
    private WebElement nameNewDashboardLabel;

    @FindBy(xpath = "//button[contains(text(), 'Create')]")
    private WebElement createNewDashboardButton;

    @FindBy(xpath = "//span[contains(text(), 'Edit Dashboard name')]")
    private WebElement nameCreatedDashboard;

    @FindBy(xpath = "//iframe[@title='dashboard']")
    private WebElement dashboardIframe;

    public DashboardPage clickNewDashboardButton() {
        logger.atInfo().log("Open window create new dashboard");
        Waiters.waitClickElementToBeClickable(driver, newDashboardButtonDiv);
        return this;
    }

    public DashboardPage fillNewDashboardName(String dashboardName) {
        logger.atInfo().log("Fill out name field for new dashboard");
        nameNewDashboardLabel.sendKeys(dashboardName);
        return this;
    }

    public void clickCreateNewDashboard() {
        logger.atInfo().log("Save new dashboard");
        Waiters.waitClickElementToBeClickable(driver, createNewDashboardButton);
    }

    public String getTextCreatedDashboard() {
        logger.atInfo().log("Get name created dashboard");
        Waiters.waitVisibilityOf(driver, nameCreatedDashboard);
        return nameCreatedDashboard.getText();
    }

    public DashboardPage findFrame() {
        Waiters.waitVisibilityOf(driver, dashboardIframe);
        driver.switchTo().frame(dashboardIframe);
        return this;
    }
}

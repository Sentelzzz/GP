package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.elements.DropDown;
import org.example.elements.SaveButtonForCreatedObjects;
import org.example.utils.Waters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalendarPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(CalendarPage.class);

    @FindBy(xpath = "//button[contains(text(), 'New Event')]")
    private WebElement newEventButton;

    public CalendarPage clickButtonCreateNewEvent() {
        logger.atInfo().log("Open window creating new event");
        Waters.waitElementToBeClickable(driver, newEventButton);
        return this;
    }

    @FindBy(xpath = "//div[contains(@class, 'slds')]//parent::label[contains(text(), 'Subject')]")
    private WebElement eventSubjectDiv;

    public CalendarPage clickSubjectField() {
        logger.atInfo().log("Open subject field");
        Waters.waitElementToBeClickable(driver, eventSubjectDiv);
        return this;
    }

    @FindBy(xpath = "//a[@class='subject-link']")
    private WebElement eventName;

    public String getTextCreatedEvent() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(eventName));
        return eventName.getText();
    }

    public CalendarPage chooseEventSubject(String subject) {
        logger.atInfo().log("Choose event subject");
        new DropDown().selectEventSubject(subject);
        return this;
    }

    public void clickSaveButton() {
        logger.atInfo().log("Save created event");
        new SaveButtonForCreatedObjects().clickSaveButton();
    }
}

package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.elements.DropDown;
import org.example.elements.SaveButtonForCreatedObjects;
import org.example.utils.Waiters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(CalendarPage.class);

    @FindBy(xpath = "//button[contains(text(), 'New Event')]")
    private WebElement newEventButton;

    @FindBy(xpath = "//div[contains(@class, 'slds')]//parent::label[contains(text(), 'Subject')]")
    private WebElement eventSubjectDiv;

    @FindBy(xpath = "//a[@class='subject-link']")
    private WebElement eventName;

    public CalendarPage clickButtonCreateNewEvent() {
        logger.atInfo().log("Open window creating new event");
        Waiters.waitClickElementToBeClickable(driver, newEventButton);
        return this;
    }

    public CalendarPage clickSubjectField() {
        logger.atInfo().log("Open subject field");
        Waiters.waitClickElementToBeClickable(driver, eventSubjectDiv);
        return this;
    }

    public String getTextCreatedEvent() {
        Waiters.waitVisibilityOf(driver, eventName);
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

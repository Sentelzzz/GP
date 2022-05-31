package org.example.elements;

import org.example.page.BasePage;
import org.example.utils.Waters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SaveButtonForCreatedObjects extends BasePage {

    @FindBy(xpath = "//button[@title = 'Save']")
    private WebElement saveButton;

    public void clickSaveButton() {
        Waters.waitElementToBeClickable(driver, saveButton);
    }

    @FindBy(xpath = "//button[@name='SaveEdit']")
    private WebElement saveForLeadContactButton;

    public void clickSaveLeadContactButton() {
        Waters.waitElementToBeClickable(driver, saveForLeadContactButton);
    }
}

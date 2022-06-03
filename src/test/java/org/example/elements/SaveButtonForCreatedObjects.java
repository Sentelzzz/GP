package org.example.elements;

import org.example.page.BasePage;
import org.example.utils.Waiters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SaveButtonForCreatedObjects extends BasePage {

    @FindBy(xpath = "//button[@title = 'Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[@name='SaveEdit']")
    private WebElement saveForLeadContactButton;

    public void clickSaveButton() {
        Waiters.waitClickElementToBeClickable(driver, saveButton);
    }

    public void clickSaveLeadContactButton() {
        Waiters.waitClickElementToBeClickable(driver, saveForLeadContactButton);
    }
}

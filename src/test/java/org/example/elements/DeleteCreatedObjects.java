package org.example.elements;

import org.example.page.BasePage;
import org.example.utils.Waiters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteCreatedObjects extends BasePage {

    @FindBy(xpath = "//th[@scope='row']/*//a")
    private WebElement createdObjectTh;

    @FindBy(xpath = "//li[contains(@class, 'dropdown')]/*/button[@class='slds-button slds-button_icon-border-filled']")
    private WebElement dropDownInObjectLi;

    @FindBy(xpath = "//div[@class='slds-dropdown slds-dropdown_right']//div/*/*[@apiname='Delete']")
    private WebElement deleteOptionDiv;

    @FindBy(xpath = "//button[@title='Delete']//span[contains(text(), 'Delete')]")
    private WebElement deleteButton;

    public void openCreatedProject() {
        Waiters.waitClickElementToBeClickable(driver, createdObjectTh);
    }

    public void deleteObject() {
        Waiters.waitClickElementToBeClickable(driver, createdObjectTh);
        Waiters.waitClickElementToBeClickable(driver, dropDownInObjectLi);
        Waiters.waitClickElementToBeClickable(driver, deleteOptionDiv);
        Waiters.waitClickElementToBeClickable(driver, deleteButton);
    }
}

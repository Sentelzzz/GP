package org.example.elements;

import org.example.page.BasePage;
import org.example.utils.Waiters;
import org.openqa.selenium.By;

public class NewObjectButton extends BasePage {

    private static final String NEW_OBJECT_BUTTON = "//div[@title='New']";

    public NewObjectButton() {
    }

    public void createNewObject() {
        Waiters.waitVisibilityOfElementLocatedLocator(driver, NEW_OBJECT_BUTTON);
        driver.findElement(By.xpath(NEW_OBJECT_BUTTON)).click();
    }
}

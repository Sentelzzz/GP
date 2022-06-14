package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.elements.Pages;
import org.example.utils.Waiters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    @FindBy(xpath = "//span[@title='Sales']")
    private WebElement nameHomePageSpan;

    public String getNameHomePage() {
        logger.atInfo().log("Get name of home page");
        Waiters.waitVisibilityOf(driver, nameHomePageSpan);
        return nameHomePageSpan.getText();
    }

    public void openNextPage(String page) {
        logger.atInfo().log("Open " + page + " page");
        new Pages(page).openNextPage();
    }

}

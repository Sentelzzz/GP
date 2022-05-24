package org.example.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    @FindBy(xpath = "//span[@title='Sales']")
    private WebElement nameHomePageSpan;

    public String getNameHomePage() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(nameHomePageSpan));
        logger.atInfo().log("Get name of home page");
        return nameHomePageSpan.getText();
    }
}

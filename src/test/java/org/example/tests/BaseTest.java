package org.example.tests;

import org.example.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseTest {

    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeTest
    public void setBrowser() {
        logger.atInfo().log("Open driver");
        driver = DriverSingleton.getInstance().getDriver();
    }

    @AfterTest
    public void closeBrowser() {
        logger.atInfo().log("Close driver");
        DriverSingleton.getInstance().closeDriver();
    }
}

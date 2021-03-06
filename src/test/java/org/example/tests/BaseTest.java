package org.example.tests;

import org.example.driver.DriverSingleton;
import org.example.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeClass(alwaysRun = true)
    public void setBrowser() {
        logger.atInfo().log("Open driver");
        driver = DriverSingleton.getInstance().getDriver();
    }

    @AfterClass
    public void closeBrowser() {
        logger.atInfo().log("Close driver");
        DriverSingleton.getInstance().closeDriver();
    }

}

package org.example.tests;

import org.example.service.DashboardPageService;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateNewDashboardTest extends BaseTest {

    private DashboardPageService dashboardPageService;

    @BeforeClass
    public void setUp() {
        dashboardPageService = new DashboardPageService();
    }

    @Test
    public void createNewDashboardTest() throws IOException, ParseException {
        dashboardPageService.createNewDashboard();
        String expectedNameNewDashboard = "Edit Dashboard name";
        String actualNameNewDashboard = dashboardPageService.getTextCreatedDashboard();
        System.out.println(actualNameNewDashboard);
        Assert.assertEquals(actualNameNewDashboard, expectedNameNewDashboard, "You didn't create new dashboard!");
    }
}

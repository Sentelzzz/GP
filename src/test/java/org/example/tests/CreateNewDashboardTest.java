package org.example.tests;

import org.example.service.DashboardPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateNewDashboardTest extends BaseTest {

    private DashboardPageService dashboardPageService;

    @BeforeTest
    public void setUp() {
        dashboardPageService = new DashboardPageService();
    }

    @Test
    public void createNewDashboardTest() {
        dashboardPageService.createNewDashboard();
        String expectedNameNewDashboard = "Edit Dashboard name";
        String actualNameNewDashboard = dashboardPageService.getTextCreatedDashboard();
        System.out.println(actualNameNewDashboard);
        Assert.assertEquals(actualNameNewDashboard, expectedNameNewDashboard, "You didn't create new dashboard!");
    }
}

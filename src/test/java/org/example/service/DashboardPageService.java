package org.example.service;

import org.example.page.DashboardPage;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import static org.example.utils.StringConstants.*;

public class DashboardPageService extends LoginPageService {

    private DashboardPage dashboardPage = new DashboardPage();

    public String getTextCreatedDashboard() {
        return dashboardPage.getTextCreatedDashboard();
    }

    public void createNewDashboard() throws IOException, ParseException {
        login("userName", "password", LOG_IN_URL).openNextPage(DASHBOARDS);
        dashboardPage.clickNewDashboardButton()
                .findFrame()
                .fillNewDashboardName(dashboard.getDashboardName())
                .clickCreateNewDashboard();
    }

}

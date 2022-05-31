package org.example.tests;

import org.example.service.CalendarPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.example.utils.StringConstants.CALL;

public class CreateNewEventTest extends BaseTest {

    private CalendarPageService calendarPageService;

    @BeforeTest
    public void setUp() {
        calendarPageService = new CalendarPageService();
    }

    @Test
    public void createNewEvent() {
        calendarPageService.createNewEvent();
        String actualEvent = calendarPageService.getTextCreatedEvent();
        Assert.assertEquals(actualEvent, CALL, "You didn't create new event!");
    }
}

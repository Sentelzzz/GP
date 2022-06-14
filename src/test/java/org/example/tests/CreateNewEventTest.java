package org.example.tests;

import org.example.service.CalendarPageService;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.example.utils.StringConstants.CALL;

public class CreateNewEventTest extends BaseTest {

    private CalendarPageService calendarPageService;

    @BeforeClass
    public void setUp() {
        calendarPageService = new CalendarPageService();
    }

    @Test
    public void createNewEvent() throws IOException, ParseException {
        calendarPageService.createNewEvent();
        String actualEvent = calendarPageService.getTextCreatedEvent();
        Assert.assertEquals(actualEvent, CALL, "You didn't create new event!");
    }
}

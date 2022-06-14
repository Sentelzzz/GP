package org.example.service;

import org.example.page.CalendarPage;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import static org.example.utils.StringConstants.*;


public class CalendarPageService extends LoginPageService{

    private final CalendarPage calendarPage = new CalendarPage();

    public String getTextCreatedEvent() {
        return calendarPage.getTextCreatedEvent();
    }

    public void createNewEvent() throws IOException, ParseException {
        login("userName", "password", LOG_IN_URL).openNextPage(CALENDAR_PAGE);
        calendarPage.clickButtonCreateNewEvent()
                .clickSubjectField()
                .chooseEventSubject(CALL)
                .clickSaveButton();
    }
}

package org.example.service;

import org.example.page.CalendarPage;

import static org.example.utils.StringConstants.*;


public class CalendarPageService extends LoginPageService{

    private CalendarPage calendarPage = new CalendarPage();

    public String getTextCreatedEvent() {
        return calendarPage.getTextCreatedEvent();
    }

    public void createNewEvent() {
        login(USERNAME, PASSWORD, LOG_IN_URL).openNextPage(CALENDAR_PAGE);
        calendarPage.clickButtonCreateNewEvent()
                .clickSubjectField()
                .chooseEventSubject(CALL)
                .clickSaveButton();
    }
}

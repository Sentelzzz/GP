package org.example.service;

import org.example.page.ContactPage;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import static org.example.utils.StringConstants.*;

public class ContactPageService extends LoginPageService {

    private ContactPage contactPage = new ContactPage();

    public String getErrorMessage() {
        return contactPage.getErrorMessage();
    }

    public String getFirstName() {
        return contact.getFirstName();
    }

    public String getLastName() {
        return contact.getLastName();
    }

    public String getTextActualCreatedContact() {
        return contactPage.getTextNameNewCreatedContact();
    }

    public void deleteNewContact() throws IOException, ParseException {
        login("userName", "password", LOG_IN_URL).openNextPage(CONTACTS_PAGE);
        contactPage.deleteCreatedContact();
    }

    public void createNewContact() throws IOException, ParseException {
        login("userName", "password", LOG_IN_URL).openNextPage(CONTACTS_PAGE);
        contactPage.clickCreateNewAccountButton()
                .fillFirstNameField(contact)
                .fillLastNameField(contact)
                .fillAccountNameField(account)
                .choseAccount(account)
                .clickSaveButton();
    }

    public void createNewIncorrectContact() throws IOException, ParseException {
        login("userName", "password", LOG_IN_URL).openNextPage(CONTACTS_PAGE);
        contactPage.clickCreateNewAccountButton()
                .fillFirstNameField(incorrectContact)
                .fillLastNameField(incorrectContact)
                .fillAccountNameField(account)
                .choseAccount(account)
                .clickSaveButton();
    }

}

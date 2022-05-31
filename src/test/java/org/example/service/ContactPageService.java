package org.example.service;

import org.example.page.ContactPage;

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

    public void deleteNewContact() {
        login(USERNAME, PASSWORD, LOG_IN_URL).openNextPage(CONTACTS_PAGE);
        contactPage.deleteCreatedContact();
    }

    public void createNewContact() throws InterruptedException {
        login(USERNAME, PASSWORD, LOG_IN_URL).openNextPage(CONTACTS_PAGE);
        contactPage.clickCreateNewAccountButton()
                .fillFirstNameField(contact)
                .fillLastNameField(contact)
                .fillAccountNameField(account)
                .choseAccount(account)
                .clickSaveNewContactButton();
    }

    public void createNewIncorrectContact() {
        login(USERNAME, PASSWORD, LOG_IN_URL).openNextPage(CONTACTS_PAGE);
        contactPage.clickCreateNewAccountButton()
                .fillFirstNameField(incorrectContact)
                .fillLastNameField(incorrectContact)
                .fillAccountNameField(account)
                .choseAccount(account)
                .clickSaveNewContactButton();
    }

}

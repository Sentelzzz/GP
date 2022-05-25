package org.example.service;

import org.example.models.Contact;
import org.example.page.ContactPage;

import static org.example.utils.StringConstants.*;

public class ContactPageService extends LoginPageService {

    private ContactPage contactPage = new ContactPage();
    private Contact contact = Contact.builder().firstName("Vadim")
            .lastName("Mialik")
            .build();

    private Contact incorrectContact = Contact.builder().firstName("")
            .lastName("")
            .build();

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
        login(USERNAME, PASSWORD, LOG_IN_URL).clickContactPageButton();
        contactPage.openContactPage()
                .openDropDownContact()
                .choseDeleteOptionDropDown()
                .deleteAccount();
    }

    public void createNewContact() {
        login(USERNAME, PASSWORD, LOG_IN_URL).clickContactPageButton();
        contactPage.clickCreateNewAccountButton()
                .fillFirstNameField(contact)
                .fillLastNameField(contact)
                .fillAccountNameField(account)
                .choseAccountForContact()
                .clickSaveNewContactButton();
    }

    public void createNewIncorrectContact() {
        login(USERNAME, PASSWORD, LOG_IN_URL).clickContactPageButton();
        contactPage.clickCreateNewAccountButton()
                .fillFirstNameField(incorrectContact)
                .fillLastNameField(incorrectContact)
                .fillAccountNameField(account)
                .choseAccountForContact()
                .clickSaveNewContactButton();
    }

}

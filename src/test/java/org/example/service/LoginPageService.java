package org.example.service;

import org.example.models.Account;
import org.example.models.Contact;
import org.example.models.Dashboard;
import org.example.models.Leads;
import org.example.page.HomePage;
import org.example.page.LoginPage;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class LoginPageService {

    private final LoginPage loginPage = new LoginPage();

    protected Account account = Account.builder().accountName("TMS")
            .industry("Education")
            .webSite("http://tms-auto.tilda.ws/qa12-onl")
            .build();

    protected Account incorrectAccount = Account.builder().accountName("")
            .industry("Education")
            .webSite("http://tms-auto.tilda.ws/qa12-onl")
            .build();

    protected Contact contact = Contact.builder().firstName("Vadim")
            .lastName("Mialik")
            .build();

    protected Contact incorrectContact = Contact.builder().firstName("")
            .lastName("")
            .build();

    protected Leads lead = Leads.builder()
            .lastName("Mialik")
            .company("TMS")
            .leadStatus("Working")
            .build();

    protected Leads incorrectLead = Leads.builder()
            .lastName("")
            .company("TMS")
            .leadStatus("New")
            .build();

    protected Dashboard dashboard = Dashboard.builder()
            .dashboardName("Test")
            .build();

    public HomePage login(String username, String password, String url) throws IOException, ParseException {
        loginPage.openPage(url)
                .fillUsernameField(username)
                .fillPasswordField(password)
                .clickLoginButton();
        return new HomePage();
    }

    public String getTextErrorMessage() {
        return loginPage.getTextErrorMessage();
    }
}

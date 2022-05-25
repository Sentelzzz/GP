package org.example.service;

import org.example.models.Account;
import org.example.page.HomePage;
import org.example.page.LoginPage;

public class LoginPageService {

    private LoginPage loginPage = new LoginPage();
    protected Account account = Account.builder().accountName("TMS")
            .industry("Education")
            .webSite("http://tms-auto.tilda.ws/qa12-onl")
            .build();

    protected Account incorrectAccount = Account.builder().accountName("")
            .industry("Education")
            .webSite("http://tms-auto.tilda.ws/qa12-onl")
            .build();

    public HomePage login(String username, String password, String url) {
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

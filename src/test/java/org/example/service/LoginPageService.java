package org.example.service;

import org.example.page.HomePage;
import org.example.page.LoginPage;

public class LoginPageService {

    LoginPage loginPage = new LoginPage();

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

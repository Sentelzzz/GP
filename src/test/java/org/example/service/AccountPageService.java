package org.example.service;

import org.example.page.AccountPage;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import static org.example.utils.StringConstants.*;

public class AccountPageService extends LoginPageService {

    private final AccountPage accountPage = new AccountPage();

    public String getAccountName() {
        return account.getAccountName();
    }

    public String getTextErrorMessageCreatingNewAccount() {
        return accountPage.getTextErrorMessageCreatingAccount();
    }

    public String getTextNameCreatedAccount() {
        return accountPage.getTextOfNameOfAccount();
    }

    public void createNewAccount() throws IOException, ParseException {
        login("userName", "password", LOG_IN_URL).openNextPage(ACCOUNT_PAGE);
        accountPage.clickCreateNewAccountButton()
                .fillAccountField(account)
                .fillWebSiteField(account)
                .choseIndustryType(account)
                .clickSaveButton();
    }

    public void deleteNewAccount() throws IOException, ParseException {
        login("userName", "password", LOG_IN_URL).openNextPage(ACCOUNT_PAGE);
        accountPage.deleteCreatedAccount();
    }

    public void createIncorrectAccount() throws IOException, ParseException {
        login("userName", "password", LOG_IN_URL).openNextPage(ACCOUNT_PAGE);
        accountPage.clickCreateNewAccountButton()
                .fillAccountField(incorrectAccount)
                .fillWebSiteField(incorrectAccount)
                .choseIndustryType(incorrectAccount)
                .clickSaveButton();
    }
}

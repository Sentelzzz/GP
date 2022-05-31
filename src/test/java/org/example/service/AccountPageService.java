package org.example.service;

import org.example.page.AccountPage;

import static org.example.utils.StringConstants.*;

public class AccountPageService extends LoginPageService {

    private AccountPage accountPage = new AccountPage();

    public String getAccountName() {
        return account.getAccountName();
    }

    public String getTextErrorMessageCreatingNewAccount() {
        return accountPage.getTextErrorMessageCreatingAccount();
    }

    public String getTextNameCreatedAccount() {
        return accountPage.getTextOfNameOfAccount();
    }

    public void createNewAccount() {
        login(USERNAME, PASSWORD, LOG_IN_URL).openNextPage(ACCOUNT_PAGE);
        accountPage.clickCreateNewAccountButton()
                .fillAccountField(account)
                .fillWebSiteField(account)
                .choseIndustryType(account)
                .clickSaveButton();
    }

    public void deleteNewAccount() {
        login(USERNAME, PASSWORD, LOG_IN_URL).openNextPage(ACCOUNT_PAGE);
        accountPage.deleteCreatedAccount();
    }

    public void createIncorrectAccount() {
        login(USERNAME, PASSWORD, LOG_IN_URL).openNextPage(ACCOUNT_PAGE);
        accountPage.clickCreateNewAccountButton()
                .fillAccountField(incorrectAccount)
                .fillWebSiteField(incorrectAccount)
                .choseIndustryType(incorrectAccount)
                .clickSaveButton();
    }
}

package org.example.service;

import org.example.models.Account;
import org.example.page.AccountPage;

import static org.example.utils.StringConstants.*;

public class AccountPageService extends LoginPageService {

    AccountPage accountPage = new AccountPage();
    Account account = Account.builder().account("TMS")
            .industry("Education")
            .webSite("http://tms-auto.tilda.ws/qa12-onl")
            .build();

    public String getAccountName() {
        return account.getAccount();
    }

    public String getTextErrorMessageCreatingNewAccount() {
        return accountPage.getTextErrorMessageCreatingAccount();
    }

    public String getTextNameCreatedAccount() {
        return accountPage.getTextOfNameOfAccount();
    }

    public void createNewAccount() {
        login(USERNAME, PASSWORD, LOG_IN_URL).clickAccountButton();
        accountPage.clickCreateNewAccountButton()
                .fillAccountField(account)
                .fillWebSiteField(account)
                .choseIndustryType(account)
                .clickSaveButton();
    }

    public void deleteNewAccount() {
        login(USERNAME, PASSWORD, LOG_IN_URL).clickAccountButton();
        accountPage.clickAccount()
                .openDropDownAccount()
                .choseDeleteOptionDropDown()
                .deleteAccount();
    }

    public void createIncorrectAccount() {
        login(USERNAME, PASSWORD, LOG_IN_URL).clickAccountButton();
        accountPage.clickCreateNewAccountButton()
                .fillWebSiteField(account)
                .choseIndustryType(account)
                .clickSaveButton();
    }
}

package com.xyzbank;

import com.xyzbank.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.BaseTest;

import static com.xyzbank.browserfactory.ManageBrowser.driver;

public class BankTest extends BaseTest {
    HomePage homePage = new HomePage();
    AccountPage accountPage = new AccountPage();
    AddCustomerPage addCustomerPage = new AddCustomerPage();
    BankManagerLoginPage bankManagerLoginPage = new BankManagerLoginPage();
    CustomerLoginPage customerLoginPage = new CustomerLoginPage();


    @Test
    public void bankManagerShouldAddCustomerSuccessfully() throws InterruptedException {
        //  click On "Bank Manager Login" Tab
        homePage.clickOnBankMangerLogin();
        // click On "Add Customer" Tab
        addCustomerPage.clickOnAddCustomer();
        // enter FirstName
        addCustomerPage.enterFirstName("Prime");
        // enter LastName
        addCustomerPage.enterLastname("Testing");
        // enter PostCode
        addCustomerPage.enterPostCode("NW10 5PT");
        //click On "Add Customer" Button
        addCustomerPage.clickOnAddButton();
        //Popup display verify message "Customer added successfully"
        String expectedText = "Customer added successfully with customer id :6";
        String actualText = addCustomerPage.verifyTextFromPopUp();
        Assert.assertEquals(actualText, expectedText);
        Thread.sleep(3000);
        //Accepting alert
        driver.switchTo().alert().accept();
    }

    @Test
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
        //  click On "Bank Manager Login" Tab
        homePage.clickOnBankMangerLogin();
        bankManagerLoginPage.clickOnOpenAccount();
        bankManagerLoginPage.clickAndSelectCustomerName();
        bankManagerLoginPage.selectCurrency();
        // 	click on "process" button
        bankManagerLoginPage.clickOnProcessButton();
        //Popup display verify message "Account created successfully"
        String expectedText = "Account created successfully with account Number :1016";
        String actualText = bankManagerLoginPage.verifyTextFromPopUp();
        Assert.assertEquals(actualText, expectedText);
        //	click on "ok" button on popup.
        bankManagerLoginPage.acceptAlert();
    }

    @Test
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        homePage.clickOnCustomerLogin();
        // search customer that you created.
        customerLoginPage.searchCustomer();
        // 	click on "Login" Button
        customerLoginPage.clickOnLoginButton();
        Thread.sleep(2000);
        verifyTwoStrings(By.xpath("//button[contains(text(),'Logout')]"),"Logout");
        Thread.sleep(2000);
        // click on "Logout"
        customerLoginPage.clickOnLogoutTab();
        //verify "Your Name" text displayed.
        Thread.sleep(2000);
        verifyTwoStrings(By.xpath("//label[contains(text(),'Your Name :')]"),"Your Name :");
        Thread.sleep(2000);
    }
    @Test
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
        //	click on "Customer Login" Tab
        homePage.clickOnCustomerLogin();
        // search customer that you created.
        customerLoginPage.searchCustomer();
        // 	click on "Login" Button
        customerLoginPage.clickOnLoginButton();
        Thread.sleep(2000);
        // click on "Deposit" Tab
        accountPage.clickOnDepositTab();
        // Enter amount 100
        accountPage.enterAmount("100");
        // click on "Deposit" Button
        accountPage.clickDepositTab();
        //verify message "Deposit Successful"
        verifyTwoStrings(By.xpath("//span[contains(text(),'Deposit Successful')]"),"Deposit Successful");

    }
    @Test
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        //	click on "Customer Login" Tab
        homePage.clickOnCustomerLogin();
        // search customer that you created.
        customerLoginPage.searchCustomer();
        // 	click on "Login" Button
        customerLoginPage.clickOnLoginButton();
        // Deposit amount
        accountPage.clickOnDepositTab();
        // Enter amount 100
        accountPage.enterAmount("100");
        // click on "Deposit" Button
        accountPage.clickDepositTab();
        // // click on "Withdrawal" Tab
        accountPage.clickOnWithdrawl();
        // 	Enter amount 50
        accountPage.enterWithdrawlAmount("50");
        //click on "Deposit" Button
        accountPage.clickOnWithdrawTransactionTab();
        //	verify message "Transaction Successful"
        String expectedText = "Transaction successful";
        String actualText = accountPage.verifyWithdrawalSuccessfullyTextMessage();
        Assert.assertEquals(actualText, expectedText, "No such message found");

    }
}

package com.xyzbank.pages;

import com.xyzbank.utilities.Utility;
import org.openqa.selenium.By;

public class AccountPage extends Utility {
    // click on "Deposit" Tab
    By deposit = By.xpath("//button[normalize-space()='Deposit']");
    // Enter amount 100
    By amountTab = By.xpath("//input[@placeholder='amount']");

    //click on "Deposit" Button
    By clickDeposit = By.xpath("//button[@type='submit']");
    // verify message "Deposit Successful"
    By depositSuccessfullyText = By.xpath("//span[contains(text(),'Deposit Successful')]");

    //click on "Withdrawl" Tab
    By withdrawl = By.xpath("//button[normalize-space()='Withdrawl']");
    // Enter amount 50
    By withdrawalAmountTab = By.xpath("//input[@placeholder='amount']");
    //click on "Deposit" Button
    By withdrawTab = By.xpath("//button[@class='btn btn-default']");
    //	verify message "Transaction Successful"
    By withdrawalSuccessfullyText = By.xpath("//span[@class='error ng-binding']");




    //click on "Deposit" Tab
    public void clickOnDepositTab() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(deposit);
    }
    // Enter amount 100
    public void enterAmount(String amount) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(amountTab, amount);
    }
    //click on "Deposit" Button
    public void clickDepositTab() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(clickDeposit);
    }
    // verify message "Deposit Successful"
    public String verifyDepositSuccessfullyTextMessage() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(depositSuccessfullyText);
    }

    //click on "Withdrawl" Tab
    public void clickOnWithdrawl() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(withdrawl);
    }

    //Enter amount 50
    public void enterWithdrawlAmount(String amount) throws InterruptedException {
        Thread.sleep(1000);
        sendTextToElement(withdrawalAmountTab, amount);
    }

    //click on "Deposit" Button
    public void clickOnWithdrawTransactionTab() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(withdrawTab);
    }

    //	verify message "Transaction Successful"
    public String verifyWithdrawalSuccessfullyTextMessage() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(withdrawalSuccessfullyText);
    }

}


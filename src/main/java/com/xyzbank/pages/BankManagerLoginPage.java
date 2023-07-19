package com.xyzbank.pages;

import com.xyzbank.utilities.Utility;
import org.openqa.selenium.By;

import static com.xyzbank.browserfactory.ManageBrowser.driver;

public class BankManagerLoginPage extends Utility {
    By openAccount = By.xpath("//button[normalize-space()='Open Account']");
    By searchCustomer = By.xpath("//select[@id='userSelect']");
    // Select currency "Pound"
    By currency = By.xpath("//select[@id='currency']");
    // 	click on "process" button
    By process = By.xpath("//button[normalize-space()='Process']");


    // click On "Open Account" Tab
    public void clickOnOpenAccount() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(openAccount);
    }

    public void clickAndSelectCustomerName() {
        selectByVisibleTextFromDropDown(searchCustomer, "Harry Potter");

    }

    //Select currency "Pound"
    public void selectCurrency() throws InterruptedException {
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(currency, "Pound");
    }
    // 	click on "process" button
    public void clickOnProcessButton() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(process);
    }

    // Popup Displayed and verify Message
    public String verifyTextFromPopUp(){
        return getTextFromAlert();
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

}

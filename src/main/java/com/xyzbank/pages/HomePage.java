package com.xyzbank.pages;


import com.xyzbank.utilities.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {

    //     click On "Bank Manager Login" Tab
    By bankManagerLogInTab = By.xpath("//button[contains(text(),'Bank Manager Login')]");
    By customerLogin = By.xpath("//button[normalize-space()='Customer Login']");


    public void clickOnBankMangerLogin() {
        clickOnElement(bankManagerLogInTab);
    }
    public void clickOnCustomerLogin() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(customerLogin);
    }

}

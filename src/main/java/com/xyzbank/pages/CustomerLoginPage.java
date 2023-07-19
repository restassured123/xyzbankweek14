package com.xyzbank.pages;


import com.xyzbank.utilities.Utility;
import org.openqa.selenium.By;

public class CustomerLoginPage extends Utility {
    // search customer that you created.
    By customer = By.xpath("//select[@id='userSelect']");
    By login = By.xpath("//button[normalize-space()='Login']");
    //click on "Logout"
    By clickLogout = By.xpath("//button[normalize-space()='Logout']");


    // search customer that you created.
    public void searchCustomer() throws InterruptedException {
        selectByVisibleTextFromDropDown(customer, "Harry Potter");
    }
    public void clickOnLoginButton() throws InterruptedException {
        clickOnElement(login);
    }
    // click on "Logout"
    public void clickOnLogoutTab() throws InterruptedException {
        clickOnElement(clickLogout);
    }


}
package com.bookit.pages;

import com.bookit.utilities.ConfigurationReader;
import com.bookit.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    //same with driver.findElement(By.id("prependedInput"));
    @FindBy(name = "email")
    public WebElement useremailInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button")
    public WebElement loginBtn;

    public void login(String usernameStr,String passwordStr){

        useremailInput.sendKeys(usernameStr);
        passwordInput.sendKeys(passwordStr);
        loginBtn.click();

    }


}
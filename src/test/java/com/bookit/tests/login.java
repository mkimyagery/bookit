package com.bookit.tests;

import com.bookit.pages.LoginPage;
import com.bookit.utilities.ConfigurationReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class login extends TestBase {


    @Test
    public void login()  {

       LoginPage loginPage = new LoginPage();
       loginPage.useremailInput.sendKeys(ConfigurationReader.get("username"));
       loginPage.passwordInput.sendKeys(ConfigurationReader.get("password"));
       loginPage.loginBtn.click();

        //String username = ConfigurationReader.get("username");
        //String password = ConfigurationReader.get("password");

       //loginPage.login(username,password);
       //loginPage.loginBtn.click();

    }

}

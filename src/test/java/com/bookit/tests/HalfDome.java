package com.bookit.tests;

import com.bookit.pages.HalfDomePage;
import com.bookit.pages.LoginPage;
import static com.bookit.utilities.BrowserUtils.*;
import com.bookit.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HalfDome extends TestBase{

    @Test
    public void testcase1(){
        /*  1. Go to “https://cybertek-reservation-qa.herokuapp.com/map"
            2. Login as a teacher
            3. Navigate to “Half Dome”
            4. Verify that page subtitle "half dome" is displayed
         */
        extentLogger = report.createTest("Page Subtitle Verification");
        extentLogger.info("Login as a teacher");
        new LoginPage().login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));
        extentLogger.info("Navigate to Activities -- Calendar Events");
        new HalfDomePage().halfDome.click();
        waitFor(3);

        String pageSubtitleText = new HalfDomePage().pageSubtitle.getText();
        System.out.println(pageSubtitleText);

        Assert.assertEquals(pageSubtitleText,"half dome", "verify page subtitle");
        extentLogger.pass("PASS: Calender Events Page Subtitle Verification Test");
    }

}

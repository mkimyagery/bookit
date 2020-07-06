package com.bookit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HalfDomePage extends PageBase {

    @FindBy(xpath = "//h2[@class='subtitle']")
    public WebElement pageSubtitle;

    @FindBy(xpath = "//span[contains(text(),'half dome')]")
    public WebElement halfDome;


}

package com.bookit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MapPage extends PageBase {

//This page added by Ahlam

    @FindBy(xpath = "//span[text()='kitchen']")
    public WebElement kitchen;

    @FindBy(xpath = "//span[text()='kilimanjaro']")
    public WebElement kilimanjaro;

    @FindBy(xpath = "//span[text()='half dome']")
    public WebElement halfDome;

    @FindBy(xpath = "//span[text()='denali']")
    public WebElement denali;

    @FindBy(xpath = "//span[text()='meru']")
    public WebElement meru;

    @FindBy(xpath = "(//span[@class='room-name'])[2]")
    public WebElement KuzatCave;

    @FindBy(xpath = "(//span[@class='room-name'])[3]")
    public WebElement forStay;


    @FindBy(xpath = "(//span[@class='room-name'])[1]")
    public WebElement oceanView;

    @FindBy(xpath = "(//span[@class='room-name'])[4]")
    public WebElement studyArea;

    @FindBy(xpath = "(//span[@class='room-name'])[6]")
    public WebElement looby;
}

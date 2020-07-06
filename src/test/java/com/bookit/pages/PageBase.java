package com.bookit.pages;



import com.bookit.utilities.BrowserUtils;
import com.bookit.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {


    @FindBy(xpath = "//*[@class='navbar-item is-active']")
    public WebElement map;

    @FindBy(xpath = "//*[@class='navbar-link']")
    public WebElement schedule;

    @FindBy(xpath = "(//*[@class='navbar-item'])[4]")
    public WebElement hunt;

    @FindBy(xpath = "(//*[@class='navbar-link'])[2]")
    public WebElement my;

    @FindBy(xpath = "(//*[@class='navbar-item'])[3]")
    public WebElement scheduleMy;

    @FindBy(xpath = "(//*[@class='navbar-item'])[4]")
    public WebElement scheduleGeneral;

    @FindBy(xpath = "(//*[@class='navbar-item'])[6]")
    public WebElement myself;

    @FindBy(xpath = "(//*[@class='navbar-item'])[7]")
    public WebElement myTeam;

    @FindBy(xpath = "(//*[@class='navbar-item button is-danger']")
    public WebElement signut;


    @FindBy(xpath = "//h1[@class='title']")
    public WebElement pageSubtitle;

    @FindBy(xpath = "//img[@class='intro-img']")
    public WebElement bookit;


    public PageBase() {
        PageFactory.initElements(Driver.get(), this);
    }


    /**
     * @return page name, for example: Dashboard
     */
    public String getPageSubTitle() {
        //ant time we are verifying page name, or page subtitle, loader mask appears
        waitUntilLoaderScreenDisappear();
//        BrowserUtils.waitForStaleElement(pageSubTitle);
        return pageSubtitle.getText();
    }


    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     */
    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            //wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }





    public void logOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(my);
        BrowserUtils.clickWithJS(signut);
    }
    public void goToMySelf(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(my, 5).click();
        BrowserUtils.waitForClickablility(myself, 5).click();


    }

    public void goToMyTeam(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(my, 5).click();
        BrowserUtils.waitForClickablility(myTeam, 5).click();


    }

    /**
     * This method will navigate user to the specific module in vytrack application.
     * For example: if tab is equals to Activities, and module equals to Calls,
     * Then method will navigate user to this page: http://qa2.vytrack.com/call/
     *
     * @param tab
     * @param module
     */
    public void navigateToModule(String tab, String module) {
        String tabLocator = "//span[normalize-space()='" + tab + "' and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[normalize-space()='" + module + "' and contains(@class, 'title title-level-2')]";
        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
            Driver.get().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)),  5);

        }
    }

}

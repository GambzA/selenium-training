package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ShopYourAccount extends BasePage{

    public WebDriver driver;

    By headTest = By.cssSelector("h1");
    By signOutBtn = By.cssSelector(" Sign out");

    public ShopYourAccount() throws IOException {
        super();
    }

    public WebElement getHeadText() throws IOException{
        this.driver = getDriver();
        return driver.findElement(headTest);
    }

    public WebElement getSignOutBtn() throws IOException{
        this.driver = getDriver();
        return driver.findElement(signOutBtn);
    }
}

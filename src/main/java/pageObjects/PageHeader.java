package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class PageHeader extends BasePage{

    public WebDriver driver;

    By loginBtn = By.linkText(" Sign in");

    public PageHeader() throws IOException {
        super();
    }

    public WebElement getLoginBtn() throws IOException{
        this.driver = getDriver();
        return driver.findElement(loginBtn);
    }
}

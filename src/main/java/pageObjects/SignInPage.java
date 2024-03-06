package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class SignInPage extends BasePage{

    public WebDriver driver;

    By emailAddress = By.cssSelector("section input[name='email']");
    By password = By.cssSelector("input[name='password']");
    By signInBtn = By.cssSelector("button#submit-login");

    public SignInPage() throws IOException {
        super();
    }

    public WebElement getEmailAddress() throws IOException{
        this.driver = getDriver();
        return driver.findElement(emailAddress);
    }

    public WebElement getPassword() throws IOException{
        this.driver = getDriver();
        return driver.findElement(password);
    }

    public WebElement getSignInBtn() throws IOException{
        this.driver = getDriver();
        return driver.findElement(signInBtn);
    }
}

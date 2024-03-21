package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class HomeContactUs extends BasePage{

    public WebDriver driver;

    By firstNameField = By.cssSelector("form#contact_form > input[name='first_name']");
    By lastNameField = By.cssSelector("form#contact_form > input[name='last_name']");
    By emailField = By.cssSelector("form#contact_form > input[name='email']");
    By commentsTextArea = By.cssSelector("form#contact_form > textarea[name='message']");

    public HomeContactUs() throws IOException {
        super();
    }

    public WebElement getFirstName() throws IOException
    {
        this.driver = getDriver();
        return driver.findElement(firstNameField); 
    }

    public WebElement getLastName() throws IOException
    {
        this.driver = getDriver();
        return driver.findElement(lastNameField); 
    }

    public WebElement getEmail() throws IOException
    {
        this.driver = getDriver();
        return driver.findElement(emailField); 
    }

    public WebElement getComment() throws IOException
    {
        this.driver = getDriver();
        return driver.findElement(commentsTextArea); 
    }
    
}

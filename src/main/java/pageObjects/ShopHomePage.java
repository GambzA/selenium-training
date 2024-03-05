package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ShopHomePage extends BasePage {
    public WebDriver driver;

    By item1 = By.linkText("Hummingbird Printed T-Shirt");
    By item2 = By.linkText("Hummingbird Printed Sweater");
    By item3 = By.linkText("The Best Is Yet To Come'...");
    By item4 = By.linkText("The Adventure Begins Framed...");
    By item5 = By.linkText("Today Is A Good Day Framed...");
    By item6 = By.linkText("Mug The Best Is Yet To Come");
    By item7 = By.linkText("Mug The Adventure Begins");
    By item8 = By.linkText("Mug Today Is A Good Day");

    public ShopHomePage() throws IOException{
		super();
	}

    public WebElement getItem1() throws IOException{
        this.driver = getDriver();
        return driver.findElement(item1);
    }

    public WebElement getItem2() throws IOException{
        this.driver = getDriver();
        return driver.findElement(item2);
    }

    public WebElement getItem3() throws IOException{
        this.driver = getDriver();
        return driver.findElement(item3);
    }

    public WebElement getItem4() throws IOException{
        this.driver = getDriver();
        return driver.findElement(item4);
    }

    public WebElement getItem5() throws IOException{
        this.driver = getDriver();
        return driver.findElement(item5);
    }

    public WebElement getItem6() throws IOException{
        this.driver = getDriver();
        return driver.findElement(item6);
    }

    public WebElement getItem7() throws IOException{
        this.driver = getDriver();
        return driver.findElement(item7);
    }

    public WebElement getItem8() throws IOException{
        this.driver = getDriver();
        return driver.findElement(item8);
    }
}

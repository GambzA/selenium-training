package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ShopProductPage extends BasePage{
    public WebDriver driver;

    By sizeOption = By.cssSelector("[data-product-attribute='1']"); 
    By quantityIncrease = By.cssSelector(".touchspin-up");
    By quantityDecrease = By.cssSelector(".touchspin-down");
    By addToCard = By.cssSelector(".add-to-cart.btn.btn-primary");
    By homePageLink = By.xpath("//span[text()=\"Home\"]");

    public ShopProductPage() throws IOException
    {
        super();
    }

    public WebElement getSizeOption() throws IOException
    {
        this.driver = getDriver();
        return driver.findElement(sizeOption);
    }

    public WebElement getQuantityIncrease() throws IOException
    {
        this.driver = getDriver();
        return driver.findElement(quantityIncrease);
    }

    public WebElement getQuantityDecrease() throws IOException
    {
        this.driver = getDriver();
        return driver.findElement(quantityDecrease);
    }

    public WebElement getAddToCard() throws IOException
    {
        this.driver = getDriver();
        return driver.findElement(addToCard);
    }

    public WebElement getHomePageLink() throws IOException
    {
        this.driver = getDriver();
        return driver.findElement(homePageLink);
    }
}

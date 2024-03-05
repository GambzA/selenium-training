package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class ShoppingCart extends BasePage {
    public WebDriver driver;

    By promoCodeBtn = By.cssSelector(".promo-code-button .collapse-button");
    By promoTextBox = By.cssSelector("input[name='discount_name']");
    By promoAddBtn  = By.cssSelector("[action='http\\:\\/\\/teststore\\.automationtesting\\.co\\.uk\\/cart'] .btn-primary");
    By proceedToCheckoutBtn = By.linkText("PROCEED TO CHECKOUT");
    By removeItemOneBtn = By.cssSelector(".cart-items .cart-item:nth-of-type(1) .float-xs-left");
    By removeItemTwoBtn = By.cssSelector(".cart-items .cart-item:nth-of-type(2) .float-xs-left");
    By totalAmount = By.cssSelector(".cart-summary-line.cart-total > .value");

    public ShoppingCart() throws IOException
    {
        super();
    }

    public WebElement getPromoCodeBtn() throws IOException
    {
        this.driver = getDriver();
        return driver.findElement(promoCodeBtn);
    }

    public WebElement getPromoTextBox() throws IOException
    {
        this.driver = getDriver();
        return driver.findElement(promoTextBox);
    }

    public WebElement getPromoAddBtn() throws IOException
    {
        this.driver = getDriver();
        return driver.findElement(promoAddBtn);
    }
    public WebElement getProceedToCheckoutBtn() throws IOException
    {
        this.driver = getDriver();
        return driver.findElement(proceedToCheckoutBtn);
    }
    public WebElement getRemoveItemOneBtn() throws IOException
    {
        this.driver = getDriver();
        return driver.findElement(removeItemOneBtn);
    }
    public WebElement getRemoveItemTwoBtn() throws IOException
    {
        this.driver = getDriver();
        return driver.findElement(removeItemTwoBtn);
    }
    public WebElement getTotalAmount() throws IOException
    {
        this.driver = getDriver();
        return driver.findElement(totalAmount);
    }
}

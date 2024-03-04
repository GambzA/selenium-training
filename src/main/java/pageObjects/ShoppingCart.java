package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart {
    public WebDriver driver;

    By promoCodeBtn = By.cssSelector(".promo-code-button .collapse-button");
    By promoTextBox = By.cssSelector("input[name='discount_name']");
    By promoAddBtn  = By.cssSelector("[action='http\\:\\/\\/teststore\\.automationtesting\\.co\\.uk\\/cart'] .btn-primary");
    By proceedToCheckoutBtn = By.linkText("PROCEED TO CHECKOUT");
    By removeItemOneBtn = By.cssSelector(".cart-items .cart-item:nth-of-type(1) .float-xs-left");
    By removeItemTwoBtn = By.cssSelector(".cart-items .cart-item:nth-of-type(2) .float-xs-left");
    By totalAmount = By.cssSelector(".cart-summary-line.cart-total > .value");

    public ShoppingCart(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getPromoCodeBtn()
    {
        return driver.findElement(promoCodeBtn);
    }

    public WebElement getPromoTextBox()
    {
        return driver.findElement(promoTextBox);
    }

    public WebElement getPromoAddBtn()
    {
        return driver.findElement(promoAddBtn);
    }
    public WebElement getProceedToCheckoutBtn()
    {
        return driver.findElement(proceedToCheckoutBtn);
    }
    public WebElement getRemoveItemOneBtn()
    {
        return driver.findElement(removeItemOneBtn);
    }
    public WebElement getRemoveItemTwoBtn()
    {
        return driver.findElement(removeItemTwoBtn);
    }
    public WebElement getTotalAmount()
    {
        return driver.findElement(totalAmount);
    }
}

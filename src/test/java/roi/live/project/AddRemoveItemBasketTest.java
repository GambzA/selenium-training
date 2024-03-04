package roi.live.project;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

import base.BasePage;
import pageObjects.Homepage;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomePage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;

public class AddRemoveItemBasketTest extends BasePage {

    public AddRemoveItemBasketTest() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException
    {
        driver = getDriver();
        driver.get(getUrl());
    }

    @AfterTest
    public void tearDown()
    {
        // quitAll();
    }

    @Test
    public void AddItemTest()
    {
        Homepage home = new Homepage(driver);
        cookieClose();
        home.getTestStoreLink().click();
        
        ShopHomePage shopHome = new ShopHomePage(driver);
        shopHome.getItem1().click();

        ShopProductPage shopProduct = new ShopProductPage(driver);
        Select option = new Select(shopProduct.getSizeOption());
        option.selectByVisibleText("M");
        shopProduct.getAddToCard().click();

        ShopContentPanel shopContent = new ShopContentPanel(driver);
        shopContent.getContinueShoppingBtn().click();

        shopProduct.getHomePageLink().click();
        shopHome.getItem2().click();
        shopProduct.getAddToCard().click();

        shopContent.getCheckoutBtn().click();

        DeleteItemTest();
    }

    @Test
    public void DeleteItemTest()
    {
        ShoppingCart cart = new ShoppingCart(driver);
        cart.getRemoveItemTwoBtn().click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.invisibilityOf(cart.getRemoveItemTwoBtn()));

        String totalAmount = cart.getTotalAmount().getText();

        System.out.println(totalAmount);
        Assert.assertEquals(totalAmount, "$26.12");
    }

}

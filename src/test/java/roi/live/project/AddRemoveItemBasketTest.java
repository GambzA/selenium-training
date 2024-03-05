package roi.live.project;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.time.Duration;

import base.Hooks;
import pageObjects.Homepage;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomePage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;

@Listeners(resources.Listeners.class)

public class AddRemoveItemBasketTest extends Hooks {

    public AddRemoveItemBasketTest() throws IOException {
        super();
    }

    @Test
    public void AddItemTest() throws IOException
    {
        Homepage home = new Homepage();
        home.getCookie().click();
        home.getTestStoreLink().click();
        
        ShopHomePage shopHome = new ShopHomePage();
        shopHome.getItem1().click();

        ShopProductPage shopProduct = new ShopProductPage();
        Select option = new Select(shopProduct.getSizeOption());
        option.selectByVisibleText("M");
        shopProduct.getAddToCard().click();

        ShopContentPanel shopContent = new ShopContentPanel();
        shopContent.getContinueShoppingBtn().click();

        shopProduct.getHomePageLink().click();
        shopHome.getItem2().click();
        shopProduct.getAddToCard().click();

        shopContent.getCheckoutBtn().click();

        ShoppingCart cart = new ShoppingCart();
        cart.getRemoveItemTwoBtn().click();

        waitForElementInvisible(cart.getRemoveItemTwoBtn(), 15);

        String totalAmount = cart.getTotalAmount().getText();

        System.out.println(totalAmount);
        Assert.assertEquals(totalAmount, "$26.12");
    }

}

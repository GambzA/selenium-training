package roi.live.project;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.ExtentManager;
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
        ExtentManager.log("Starting AddRemoveItemBasketTest...");

        Homepage home = new Homepage();
        home.getCookie().click();
        home.getTestStoreLink().click();
        
        ShopHomePage shopHome = new ShopHomePage();
        ExtentManager.pass("Reached the shop homepage");
        shopHome.getItem1().click();

        ShopProductPage shopProduct = new ShopProductPage();
        ExtentManager.pass("Reached the product page");
        Select option = new Select(shopProduct.getSizeOption());
        option.selectByVisibleText("M");
        ExtentManager.pass("Successfully selected M size");
        shopProduct.getAddToCard().click();

        ShopContentPanel shopContent = new ShopContentPanel();
        ExtentManager.pass("Reached shop content panel");
        shopContent.getContinueShoppingBtn().click();

        shopProduct.getHomePageLink().click();
        ExtentManager.pass("Returned back to homepage");
        shopHome.getItem2().click();
        ExtentManager.pass("Selected Item 2");
        shopProduct.getAddToCard().click();

        shopContent.getCheckoutBtn().click();

        ShoppingCart cart = new ShoppingCart();
        ExtentManager.pass("Reached shopping cart");
        cart.getRemoveItemTwoBtn().click();

        waitForElementInvisible(cart.getRemoveItemTwoBtn(), 15);

        String totalAmount = cart.getTotalAmount().getText();

        try {
            Assert.assertEquals(totalAmount, "$26.12");
            ExtentManager.pass("Total amount is equal");
        } catch (Exception e) {
            Assert.fail("Total amount is different!");
            ExtentManager.fail("Total amount is different!");
        }
    }

}

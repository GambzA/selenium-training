package roi.live.project;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import base.ExtentManager;
import base.Hooks;
import pageObjects.Homepage;
import pageObjects.OrderFormDelivery;
import pageObjects.OrderFormPayment;
import pageObjects.OrderFormPersInfo;
import pageObjects.OrderFormShippingMethod;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomePage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;

@Listeners(resources.Listeners.class)

public class OrderCompleteTest extends Hooks {

    public OrderCompleteTest() throws IOException 
    {
        super();
    }

    @Test
    public void endToEndTest() throws IOException
    {
        ExtentManager.log("Starting OrderCompleteTest...");


        Homepage home = new Homepage();
        ExtentManager.pass("Reached the shop homepage");
        home.getCookie().click();
        home.getTestStoreLink().click();
        
        ShopHomePage shopHome = new ShopHomePage();
        ExtentManager.pass("Reached the product list");
        shopHome.getItem1().click();

        ShopProductPage shopProduct = new ShopProductPage();
        ExtentManager.pass("Reached the shop product page");
        Select option = new Select(shopProduct.getSizeOption());
        option.selectByVisibleText("M");
        ExtentManager.pass("Successfully selected M size");
        shopProduct.getQuantityIncrease().click();
        ExtentManager.pass("Increased quantity");
        shopProduct.getAddToCard().click();

        ShopContentPanel shopContent = new ShopContentPanel();
        ExtentManager.pass("Reached shop content panel");
        shopContent.getCheckoutBtn().click();

        ShoppingCart shopCart = new ShoppingCart();
        ExtentManager.pass("Reached shopping cart");
        shopCart.getPromoCodeBtn().click();
        shopCart.getPromoTextBox().sendKeys("20OFF");
        ExtentManager.pass("Applied 20OFF discount");
        shopCart.getPromoAddBtn().click();
        shopCart.getProceedToCheckoutBtn().click();

        OrderFormPersInfo persInfo = new OrderFormPersInfo();
        ExtentManager.pass("Reached Person Info Page");
        persInfo.getGenderMr().click();
        persInfo.getFirstNameField().sendKeys("Roi");
        persInfo.getLastnameField().sendKeys("Gamba");
        persInfo.getEmailField().sendKeys("gambaroimark@gmail.com");
        persInfo.getTermsConditionsCheckbox().click();
        persInfo.getContinueBtn().click();

        OrderFormDelivery delivery = new OrderFormDelivery();
        ExtentManager.pass("Reached delivery details page");
        delivery.getCompanyField().sendKeys("Bizmates");
        delivery.getAddressField().sendKeys("Muntinlupa");
        delivery.getAddressCompField().sendKeys("Insular Bldg");
        delivery.getCityField().sendKeys("Alabang");
        Select state = new Select(delivery.getStateDropdown());
        state.selectByVisibleText("Utah");
        delivery.getPostcodeField().sendKeys("12345");
        delivery.getContinueBtn().click();
        
        OrderFormShippingMethod shipping = new OrderFormShippingMethod();
        ExtentManager.pass("Reached shipping method page");
        shipping.getDeliveryMsgTextbox().sendKeys("Leave my package at the gate");
        shipping.getContinueBtn().click();

        OrderFormPayment payment = new OrderFormPayment();
        ExtentManager.pass("Reached order form");
        payment.getPayByCheckRadioBtn().click();
        payment.getTermsConditionsCheckbox().click();
        payment.getOrderBtn().click();

        ExtentManager.pass("Successful Item Purchase");
    }
}

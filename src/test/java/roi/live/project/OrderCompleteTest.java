package roi.live.project;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
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
        Homepage home = new Homepage();
        home.getCookie().click();
        home.getTestStoreLink().click();
        
        ShopHomePage shopHome = new ShopHomePage();
        shopHome.getItem1().click();

        ShopProductPage shopProduct = new ShopProductPage();
        Select option = new Select(shopProduct.getSizeOption());
        option.selectByVisibleText("M");
        shopProduct.getQuantityIncrease().click();
        shopProduct.getAddToCard().click();

        ShopContentPanel shopContent = new ShopContentPanel();
        shopContent.getCheckoutBtn().click();

        ShoppingCart shopCart = new ShoppingCart();
        shopCart.getPromoCodeBtn().click();
        shopCart.getPromoTextBox().sendKeys("20OFF");
        shopCart.getPromoAddBtn().click();
        shopCart.getProceedToCheckoutBtn().click();

        OrderFormPersInfo persInfo = new OrderFormPersInfo();
        persInfo.getGenderMr().click();
        persInfo.getFirstNameField().sendKeys("Roi");
        persInfo.getLastnameField().sendKeys("Gamba");
        persInfo.getEmailField().sendKeys("gambaroimark@gmail.com");
        persInfo.getTermsConditionsCheckbox().click();
        persInfo.getContinueBtn().click();

        OrderFormDelivery delivery = new OrderFormDelivery();
        delivery.getCompanyField().sendKeys("Bizmates");
        delivery.getAddressField().sendKeys("Muntinlupa");
        delivery.getAddressCompField().sendKeys("Insular Bldg");
        delivery.getCityField().sendKeys("Alabang");
        Select state = new Select(delivery.getStateDropdown());
        state.selectByVisibleText("Utah");
        delivery.getPostcodeField().sendKeys("12345");
        delivery.getContinueBtn().click();
        
        OrderFormShippingMethod shipping = new OrderFormShippingMethod();
        shipping.getDeliveryMsgTextbox().sendKeys("Leave my package at the gate");
        shipping.getContinueBtn().click();

        OrderFormPayment payment = new OrderFormPayment();
        payment.getPayByCheckRadioBtn().click();
        payment.getTermsConditionsCheckbox().click();
        payment.getOrderBtn().click();
    }
}

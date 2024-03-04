package roi.live.project;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import base.BasePage;
import pageObjects.Homepage;
import pageObjects.OrderFormDelivery;
import pageObjects.OrderFormPayment;
import pageObjects.OrderFormPersInfo;
import pageObjects.OrderFormShippingMethod;
import pageObjects.ShopContentPanel;
import pageObjects.ShopHomePage;
import pageObjects.ShopProductPage;
import pageObjects.ShoppingCart;

public class OrderCompleteTest extends BasePage {

    public OrderCompleteTest() throws IOException 
    {
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
    public void endToEndTest()
    {
        Homepage home = new Homepage(driver);
        cookieClose();
        home.getTestStoreLink().click();
        
        ShopHomePage shopHome = new ShopHomePage(driver);
        shopHome.getItem1().click();

        ShopProductPage shopProduct = new ShopProductPage(driver);
        Select option = new Select(shopProduct.getSizeOption());
        option.selectByVisibleText("M");
        shopProduct.getQuantityIncrease().click();
        shopProduct.getAddToCard().click();

        ShopContentPanel shopContent = new ShopContentPanel(driver);
        shopContent.getCheckoutBtn().click();

        ShoppingCart shopCart = new ShoppingCart(driver);
        shopCart.getPromoCodeBtn().click();
        shopCart.getPromoTextBox().sendKeys("20OFF");
        shopCart.getPromoAddBtn().click();
        shopCart.getProceedToCheckoutBtn().click();

        OrderFormPersInfo persInfo = new OrderFormPersInfo(driver);
        persInfo.getGenderMr().click();
        persInfo.getFirstNameField().sendKeys("Roi");
        persInfo.getLastnameField().sendKeys("Gamba");
        persInfo.getEmailField().sendKeys("gambaroimark@gmail.com");
        persInfo.getTermsConditionsCheckbox().click();
        persInfo.getContinueBtn().click();

        OrderFormDelivery delivery = new OrderFormDelivery(driver);
        delivery.getCompanyField().sendKeys("Bizmates");
        delivery.getAddressField().sendKeys("Muntinlupa");
        delivery.getAddressCompField().sendKeys("Insular Bldg");
        delivery.getCityField().sendKeys("Alabang");
        Select state = new Select(delivery.getStateDropdown());
        state.selectByVisibleText("Utah");
        delivery.getPostcodeField().sendKeys("12345");
        delivery.getContinueBtn().click();
        
        OrderFormShippingMethod shipping = new OrderFormShippingMethod(driver);
        shipping.getDeliveryMsgTextbox().sendKeys("Leave my package at the gate");
        shipping.getContinueBtn().click();

        OrderFormPayment payment = new OrderFormPayment(driver);
        payment.getPayByCheckRadioBtn().click();
        payment.getTermsConditionsCheckbox().click();
        payment.getOrderBtn().click();
    }
}

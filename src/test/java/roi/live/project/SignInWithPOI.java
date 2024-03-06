package roi.live.project;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

import base.ExtentManager;
import base.Hooks;
import pageObjects.Homepage;
import pageObjects.PageHeader;
import pageObjects.ShopYourAccount;
import pageObjects.SignInPage;

@Listeners(resources.Listeners.class)

public class SignInWithPOI extends Hooks{

    public SignInWithPOI() throws IOException {
        super();
    }
    
    @Test
    public void LoginTest() throws IOException
    {
        ExtentManager.log("Starting SignInWithPOI...");

        Homepage home = new Homepage();
        home.getCookie().click();
        home.getTestStoreLink().click();
        
        PageHeader header = new PageHeader();
        ExtentManager.pass("Reached the shop homepage");
        header.getLoginBtn().click();

        SignInPage signin = new SignInPage();
        ExtentManager.pass("Reached the sign in page");

        FileInputStream credentialWorkbook = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\credentials.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(credentialWorkbook);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Row row1 = sheet.getRow(1);
        String email = row1.getCell(0).getStringCellValue();
        String pass = row1.getCell(1).getStringCellValue();

        signin.getEmailAddress().sendKeys(email);
        signin.getPassword().sendKeys(pass);
        
        signin.getSignInBtn().click();
        ExtentManager.pass("User successfully logged in");
        ShopYourAccount youraccount = new ShopYourAccount();

        waitForElementVisible(youraccount.getHeadText(), 15);

        try {
            Assert.assertEquals(youraccount.getHeadText().getText(), "Your account");
            ExtentManager.pass("Credentials can be logged in");
        } catch (Exception e) {
            Assert.fail("Login unsuccessful");
            ExtentManager.fail("Login unsuccessful");
        }

    }
}

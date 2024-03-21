package roi.live.project;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.ExtentManager;
import base.Hooks;
import pageObjects.Homepage;

@Listeners(resources.Listeners.class)

public class ContactUsTest extends Hooks{

    public ContactUsTest() throws IOException {
        super();
    }

    @Test
    public void ContactUsFillTest() throws IOException
    {
        ExtentManager.log("Starting Contact Us Fill Test with Cucumber Gherkin");

        Homepage home = new Homepage();
        home.getCookie().click();
        home.getContactUsLink().click();
    }
    
}

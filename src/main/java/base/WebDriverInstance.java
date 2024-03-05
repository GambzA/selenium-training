package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverInstance 
{
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
    public static WebDriver getDriver()
    {
        if(driver.get() == null) {
            try {
                driver.set(creatWebDriver());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return driver.get();
    }

    public static WebDriver creatWebDriver() throws IOException
    {
        WebDriver driver = null;
        Properties prop = new Properties();
		FileInputStream data = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties");
		prop.load(data);

        if (prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
            System.err.println("No browser setup in Config.properties");
            throw new IllegalArgumentException("Unsupported browser specified in Config.properties");
        }

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		return driver;
    }

    public static void cleanDriver()
    {
        driver.get().quit();
        driver.remove();
    }
}

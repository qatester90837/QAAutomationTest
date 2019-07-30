package qa.object;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected  WebDriver driver;
    private long animationDelay = 2000;

    @BeforeClass
    public void setup() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        Thread.sleep(animationDelay);
    }

    @AfterClass
    public void tearDown() throws Exception {
        if(driver != null) {
            Thread.sleep(animationDelay);
            driver.quit();
        }
    }

}
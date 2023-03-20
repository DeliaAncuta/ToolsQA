package ShareData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ShareData {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void initBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://shop.demoqa.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    public void clearBrowser(){
        driver.quit();
    }
}

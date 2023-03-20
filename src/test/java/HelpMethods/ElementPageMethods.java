package HelpMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElementPageMethods {

    private WebDriver driver;

    public ElementPageMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitElementVisible(WebElement element){
        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitExplicit.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickElement(WebElement element){
        waitElementVisible(element);
        element.click();
    }

    public void sendKeysElement(WebElement element, String value){
        waitElementVisible(element);
        element.sendKeys(value);
    }

    public void validateElementText(WebElement element, String value){
        waitElementVisible(element);
        String actualValue = element.getText();
        Assert.assertEquals(value, actualValue, "Action performed correctly!");
    }

    public void scrollByPixel(Integer x, Integer y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+","+y+")");
    }

}

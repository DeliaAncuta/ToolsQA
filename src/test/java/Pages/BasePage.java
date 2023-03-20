package Pages;

import HelpMethods.ElementPageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;

    public ElementPageMethods elementPageMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementPageMethods = new ElementPageMethods(driver);
    }

}

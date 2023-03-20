package Pages;

import Objects.AddToWishlistObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    Boolean staleElement = true;

    @FindBy(css= ".noo-search")
    private WebElement searchBtn;

    @FindBy(css=".form-control")
    private WebElement searchBar;

    @FindBy(css="div[data-fragment-ref=\"1485\"]>div>a")
    private WebElement addWishlistBtn;

    @FindBy(css="#yith-wcwl-message")
    private WebElement ProductAddedMessage;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public HomePage clickSearch(){
        elementPageMethods.clickElement(searchBtn);
        return this;
    }
    public HomePage searchValue(AddToWishlistObject addToWishlistObject){
        elementPageMethods.sendKeysElement(searchBar, addToWishlistObject.getSearchValue());
        searchBar.sendKeys(Keys.ENTER); //de revenit aici
        return this;
    }

    public HomePage addToWishlist(){

        while(staleElement){
            try{
                elementPageMethods.scrollByPixel(0, 300);
                elementPageMethods.clickElement(addWishlistBtn);
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
        return this;
    }

    public HomePage validateAddedProduct(AddToWishlistObject addToWishlistObject){
        elementPageMethods.validateElementText(ProductAddedMessage, addToWishlistObject.getAddedProductMessage());
        elementPageMethods.scrollByPixel(0, -600);
        return this;
    }

}

package Pages;

import Objects.AddToWishlistObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishlistPage extends BasePage{


    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css=".woocommerce-store-notice__dismiss-link")
    private WebElement DismissBtn;

    @FindBy(css="a[href=\"https://shop.demoqa.com/wishlist/\"]")
    private WebElement WishListBtn;

    @FindBy (css = ".wishlist-empty")
    private WebElement EmptyListMessage;

    @FindBy(css=".wishlist-items-wrapper")
    private List<WebElement> AddedProducts;

    public WishlistPage clickDismiss(){
        elementPageMethods.clickElement(DismissBtn);
        return this;
    }


    public WishlistPage clickWishList(){
        elementPageMethods.clickElement(WishListBtn);
        return this;
    }

    public WishlistPage validateListEmpty(AddToWishlistObject addToWishlistObject) {
        elementPageMethods.validateElementText(EmptyListMessage, addToWishlistObject.getValue());
        return this;
    }

    public WishlistPage validateListNotEmpty(AddToWishlistObject addToWishlistObject){
        for (Integer i = 0; i< AddedProducts.size(); i++){
            if(AddedProducts.size() == 0){
                elementPageMethods.validateElementText(EmptyListMessage, addToWishlistObject.getValue());
            }
            System.out.println(addToWishlistObject.getWishlistMessage());
        }
        return this;
    }


}

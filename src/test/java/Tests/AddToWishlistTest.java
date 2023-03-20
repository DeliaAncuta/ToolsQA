package Tests;

import Objects.AddToWishlistObject;
import Pages.HomePage;
import Pages.WishlistPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class AddToWishlistTest extends Hooks {

    @Test
    public void metodaTest(){

        AddToWishlistObject addToWishlistObject = new AddToWishlistObject(testData);


        WishlistPage wishlistPage = new WishlistPage(getDriver());
        wishlistPage.clickDismiss()
                    .clickWishList()
                    .validateListEmpty(addToWishlistObject);
        testReport.attacheReport("pass", "Wishlist is empty!");


        HomePage homePage = new HomePage(getDriver());
        homePage.clickSearch()
                .searchValue(addToWishlistObject)
                .addToWishlist()
                .validateAddedProduct(addToWishlistObject);
        testReport.attacheReport("pass", "Added product to wishlist");


        wishlistPage.clickWishList()
                    .validateListNotEmpty(addToWishlistObject);
        testReport.attacheReport("pass", "Wishlist NOT empty!");
    }
}

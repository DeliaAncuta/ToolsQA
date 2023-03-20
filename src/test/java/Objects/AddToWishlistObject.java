package Objects;

import java.util.HashMap;

public class AddToWishlistObject {

    private String value;
    private String searchValue;
    private String addedProductMessage;
    private String wishlistMessage;

    public AddToWishlistObject(HashMap<String, String> testData) {
        populateObject(testData);
    }

    private void populateObject(HashMap<String, String> testData){
        for(String key: testData.keySet()){
            switch (key){
                case "value":
                    setValue(testData.get(key));
                    break;
                case "searchValue":
                    setSearchValue(testData.get(key));
                    break;
                case "addedProductMessage":
                    setAddedProductMessage(testData.get(key));
                    break;
                case "wishlistMessage":
                    setWishlistMessage(testData.get(key));
                    break;
            }
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getAddedProductMessage() {
        return addedProductMessage;
    }

    public void setAddedProductMessage(String addedProductMessage) {
        this.addedProductMessage = addedProductMessage;
    }

    public String getWishlistMessage() {
        return wishlistMessage;
    }

    public void setWishlistMessage(String wishlistMessage) {
        this.wishlistMessage = wishlistMessage;
    }
}



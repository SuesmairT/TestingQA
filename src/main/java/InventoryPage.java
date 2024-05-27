import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class InventoryPage {
    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-test=\"title\"]")
    private WebElement tittleText;

    @FindBy(className = "inventory_list")
    private WebElement inventoryList;

    @FindBy(className = "inventory_item")
    private List<WebElement> items;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemNames;


    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackToCart;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addLightToCart;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement addTShirtToCart;

    @FindBy(id= "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addJacketToCart;


    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    private WebElement addOnesieToCart;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartIcon;






    public boolean inventoryListIsDisplayed(){
        return inventoryList.isDisplayed();
    }



    public int getItemQuantity(){
        return items.size();
    }

    public boolean allItemsAreDisplayed(){
        boolean displayed = true;
        for (WebElement item: items) {
            if(!item.isDisplayed()){
                displayed = false;
            }
        }
        return displayed;
    }

    public boolean allItemsNamesAreDisplayed(){
        boolean displayed = true;
        for (WebElement itemName: itemNames) {
            if (!itemName.isDisplayed()){
                displayed = false;
            }
        }
        return displayed;
    }

    public boolean allItemNamesAreNotEmpty(){
        boolean notEmpty = true;
        for (WebElement itemName: itemNames) {
            if (itemName.getText().isEmpty()){
                notEmpty = false;
            }
        }
        return notEmpty;
    }




    public boolean allItemNameStartsSauceLabs(){
        boolean startWithSauce = true;
        for (WebElement itemName: itemNames){
            if (itemName.getText().startsWith("Sauce Labs")){
                startWithSauce = false;
            }
        }
        return startWithSauce;
    }

    public String titleTextIsProducts() {
        return tittleText.getText();
    }

    public void clickOnAddToCartButton(){
        addBackpackToCart.click();
    }

    public String getItemsQuantityCartBadge(){
        return cartBadge.getText();
    }

    public void clickOnAddLightToCart(){
        addLightToCart.click();
    }

    public void clickOnAddTShirtToCart(){
        addTShirtToCart.click();
    }

    public void clickOnShoppingCartIcon(){
        shoppingCartIcon.click();
    }

    public void clickOnAddJacketToCart(){
        addJacketToCart.click();
    }

    public void clickOnAddOnesieToCart(){
        addOnesieToCart.click();
    }

    public String getNameOfTheFirstItem(){
        return itemNames.get(0).getText();
    }

}









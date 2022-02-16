package ui;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@NoArgsConstructor(access= AccessLevel.PRIVATE)
public class InventoryPageUI {

    public static final Target BTN_SHOPPINGCART = Target
            .the("shopping cart button")
            .located(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));


    public static final Target BTN_ADD_FIRST_PRODUCT = Target
            .the("product to select")
            .located(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));

    /**
     * here to replace string in xpath
     * to avoid "The of() method is not supported for By-type Targets" issue ?
     * when method located(By.xpath('the xpath') is used
     */
    public static final Target MAINMENU_SELECTION   = Target
            .the("main selection")
            .locatedBy("//*[text()='{0}']");

    public static final Target BTN_BURGER_MENU = Target
            .the("burger menu button")
            .located(By.xpath("//*[@id='react-burger-menu-btn']"));

    public static final Target SVG_PRODUCTS_COUNTER = Target
            .the("red dot over shopping cart counting items in the cart")
            .locatedBy("//*[@id=\"shopping_cart_container\"]/a/span");

    public static final Target SELECTION = Target
            .the("sort product dropdown")
            .locatedBy("//*[text()=\"{0}\"]");

    public static final Target ITEM = Target
            .the("item cart in inventory")
            .located(By.xpath("//*[@class=\"inventory_list\"]/div[1]"));

    public static final Target ITEM_LBLNAME = Target
            .the("the ordered item in the inventory")
            .locatedBy("//*[text()='{0}']"); // here we pass a string to the xpath

    public static final Target ITEM_LBLPRICE = Target
            .the("the item in the inventory")
            .locatedBy("//*[text()='$']");


    public static final Target INVENTORY_CONTAINER = Target
            .the("items container list")
            .locatedBy("//div[@class=\"inventory_list\"]/div");


    public static final Target ITEM_IMAGE = Target
            .the("image of item in inventory") // here we pass an integer to the xpath
            .locatedBy("//*[@class=\"inventory_list\"]/div[{0}]/div/a/img");

    public static final Target BTN_ADD = Target
            .the("button add to cart") // here we pass an integer to the xpath
            .locatedBy("//*[@class=\"inventory_list\"]/div[{0}]/div[2]/div[2]/button");
}

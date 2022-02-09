package ui;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InventoryPageUI {

    public static final Target BTN_SHOPPINGCART = Target
            .the("shopping cart button")
            .located(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));

    
    public static final Target  BTN_ADDPRODUCT = Target
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

    public static final Target SVG_ = Target
            .the("red dot over shopping cart counting items in the cart")
            .locatedBy("//*[@id=\"shopping_cart_container\"]/a/span");
}


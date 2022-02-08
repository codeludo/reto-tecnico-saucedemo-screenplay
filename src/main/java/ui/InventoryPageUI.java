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

    public static final Target MAINMENU_SELECTION   = Target
            .the("main selection")
            .located(By.xpath("//*[@id='{0}']"));
}


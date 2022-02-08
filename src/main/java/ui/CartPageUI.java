package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPageUI {

    public static final Target LBL_PRODUCT = Target
            .the("selected product")
            .located(By.xpath(" //*[@id=\"item_4_title_link\"]/div"));
}

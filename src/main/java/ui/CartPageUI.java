package ui;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@NoArgsConstructor(access=AccessLevel.PRIVATE)
public class CartPageUI {

    public static final Target LBL_PRODUCT = Target
            .the("selected product")
            .located(By.xpath(" //*[@id=\"item_4_title_link\"]/div"));

    public static final Target BTN_CHECKOUT = Target
            .the("checkout button")
            .located(By.xpath("//*[@id=\"checkout\"]"));
}

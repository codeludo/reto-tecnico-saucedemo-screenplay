package questions;

import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static ui.CartPageUI.LBL_PRODUCT;

@NoArgsConstructor
public class VerifyProduct  implements Question<Boolean> {


    public static VerifyProduct onCartPage() {
        return new VerifyProduct();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return LBL_PRODUCT.resolveFor(actor).getText().contains("Sauce Labs Backpack");
    }
}

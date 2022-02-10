package questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static ui.CheckoutPageUI.H2_CHECKOUTCOMPLETE;

@AllArgsConstructor
public class TheSuccessfulMessageCheckout implements Question<Boolean> {

    String data;

    public static TheSuccessfulMessageCheckout isTheMessage(String message) {
        return new TheSuccessfulMessageCheckout(message);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return H2_CHECKOUTCOMPLETE.resolveFor(actor).getText().contains(data);
    }
}

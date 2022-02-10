package actions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static ui.CheckoutPageUI.*;

@AllArgsConstructor
public class CheckoutPurchase implements Interaction {

    private Map<String, String> data;

    public static CheckoutPurchase toVerifyPurchase(Map<String, String> withTax) {
        return instrumented(CheckoutPurchase.class, withTax);
    }
    public static CheckoutPurchase toVerifyPurchase() {
        return instrumented(CheckoutPurchase.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(data.get("First Name")).into(TXTB_FIRSTNAME));
        actor.attemptsTo(Enter.theValue(data.get("Last Name")).into(TXTB_LASTNAME));
        actor.attemptsTo(Enter.theValue(data.get("Zip")).into(TXTB_ZIPCODE));
        actor.attemptsTo(Click.on(BTN_CONTINUE));

    }
}

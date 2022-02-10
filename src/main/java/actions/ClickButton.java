package actions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static ui.CartPageUI.BTN_CHECKOUT;

@AllArgsConstructor
public class ClickButton implements Interaction {

    public static ClickButton toCheckout() {
        return instrumented(ClickButton.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BTN_CHECKOUT));
    }
}

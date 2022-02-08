package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static ui.InventoryPageUI.BTN_SHOPPINGCART;

public class GoToShoppingCart implements Task {


    public static GoToShoppingCart onCartPage() {
        return instrumented(GoToShoppingCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BTN_SHOPPINGCART));

    }
}

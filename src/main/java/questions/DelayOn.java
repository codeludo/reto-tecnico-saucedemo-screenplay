package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


import static ui.InventoryPageUI.INVENTORY_CONTAINER;

public class DelayOn implements Question<Boolean> {

    public static DelayOn changePage() {
        return new DelayOn();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        //serenity waits for default 5s
        //https://serenity-bdd.github.io/theserenitybook/latest/serenity-screenplay-ensure.html#_waiting_for_elements_and_defining_timeouts
        return INVENTORY_CONTAINER.resolveFor(actor).shouldBeCurrentlyVisible().isVisible();
    }
}

package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static ui.InventoryPageUI.*;

public class ChooseAllProducts implements Task {


    public static ChooseAllProducts onInventoryPage() {
        return instrumented(ChooseAllProducts.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 1; i <= INVENTORY_LIST.resolveAllFor(actor).size(); i++) {
            actor.attemptsTo(Click.on(BTN_ADD.of(String.valueOf(i))));
        }
    }
}

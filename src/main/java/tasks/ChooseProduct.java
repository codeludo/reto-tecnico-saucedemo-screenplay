package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static ui.InventoryPageUI.*;

public class ChooseProduct implements Task {


    public static ChooseProduct onInventoryPage() {
        return instrumented(ChooseProduct.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BTN_ADD_FIRST_PRODUCT));

    }
}

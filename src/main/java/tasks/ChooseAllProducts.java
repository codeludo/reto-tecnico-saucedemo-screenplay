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
        for (int i = 1; i <= INVENTORY_CONTAINER.resolveAllFor(actor).size(); i++) {
            System.out.println(i);


            actor.attemptsTo(Click.on(BTN_ADD.of(String.valueOf(1))));
            System.out.println(BTN_ADD.of(String.valueOf(i)).resolveFor(actor).getElement());
            actor.attemptsTo(Click.on(BTN_ADD.of(String.valueOf(i))));

            System.out.println(BTN_ADD.of(String.valueOf(i)).resolveFor(actor).getAttribute("id"));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//*[@class="inventory_list"]/div[3]/div[2]/div[2]/button

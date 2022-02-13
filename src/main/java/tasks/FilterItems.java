package tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static ui.InventoryPageUI.SELECTION;

@AllArgsConstructor
public class FilterItems implements Task {

    Map<String, String> items;


    public static FilterItems throughSelection(Map<String, String> selection) {
        return instrumented(FilterItems.class, selection);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(SELECTION.of(items.get("selection"))));
    }
}

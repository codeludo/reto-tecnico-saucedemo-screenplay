package tasks;

import lombok.AllArgsConstructor;
import models.MainMenuSelection;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static ui.InventoryPageUI.BTN_BURGER_MENU;
import static ui.InventoryPageUI.MAINMENU_SELECTION;

@AllArgsConstructor
public class GoToOtherPage implements Task {

    Map<String, String> selection;

    public static GoToOtherPage onMainMenu(Map<String, String> choice) {
        return instrumented(GoToOtherPage.class, choice);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BTN_BURGER_MENU));
        actor.attemptsTo(Click.on(MAINMENU_SELECTION.of(selection.get("selection"))));

    }
}

package tasks;

import lombok.AllArgsConstructor;
import models.MainMenuSelection;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static ui.InventoryPageUI.MAINMENU_SELECTION;

@AllArgsConstructor
public class GoToAbout implements Task {

    MainMenuSelection selection;

    public static GoToAbout onMainMenu(MainMenuSelection choice) {
        return instrumented(GoToAbout.class, choice);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(MAINMENU_SELECTION.of(selection.getChoice())));

    }
}

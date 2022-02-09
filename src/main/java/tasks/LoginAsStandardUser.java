package tasks;

import actions.LoginAs;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static ui.LoginPageUI.*;

@AllArgsConstructor
public class LoginAsStandardUser implements Task {

    private final Map<String, String> data;

    public static LoginAsStandardUser onTheSaucedemoPage(Map<String, String> data) {
        return instrumented(LoginAsStandardUser.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Enter.theValue(data.get("username")).into(TXTB_USERNAME));
        actor.attemptsTo(Enter.theValue(data.get("password")).into(TXTB_PASSWORD));
        actor.attemptsTo(Click.on(BTN_LOGIN));

    }
}

package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static ui.LoginPageUI.ERROR_MESSAGE;

public class ErrorMessage implements Question<Boolean> {

    public static ErrorMessage appears() {
        return new ErrorMessage();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return ERROR_MESSAGE.resolveFor(actor).isVisible();
    }
}

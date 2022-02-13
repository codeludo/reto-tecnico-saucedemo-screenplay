package tasks;

import lombok.AllArgsConstructor;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static ui.LoginPageUI.*;

@AllArgsConstructor
public class Login implements Task {

    String userType;
    User user;

    public Login(String userType) {
        this.userType = userType;
    }

    public static Login as(String typeUser) {
        return instrumented(Login.class, typeUser);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        switch(userType){
            case "locked out user":
                actor.attemptsTo(Enter.theValue(User.getLockedOutUSer()).into(TXTB_USERNAME));
                actor.attemptsTo(Enter.theValue(User.getPassword()).into(TXTB_PASSWORD));
                actor.attemptsTo(Click.on(BTN_LOGIN));
                break;
            case "problem user":
                actor.attemptsTo(Enter.theValue(User.getProblemUser()).into(TXTB_USERNAME));
                actor.attemptsTo(Enter.theValue(User.getPassword()).into(TXTB_PASSWORD));
                actor.attemptsTo(Click.on(BTN_LOGIN));
                break;
            case "performance glitch user":
                actor.attemptsTo(Enter.theValue(User.getPerformanceGlitchUser()).into(TXTB_USERNAME));
                actor.attemptsTo(Enter.theValue(User.getPassword()).into(TXTB_PASSWORD));
                actor.attemptsTo(Click.on(BTN_LOGIN));
                break;
            default:
                actor.attemptsTo(Enter.theValue(User.getStandardUser()).into(TXTB_USERNAME));
                actor.attemptsTo(Enter.theValue(User.getPassword()).into(TXTB_PASSWORD));
                actor.attemptsTo(Click.on(BTN_LOGIN));
                break;
        }
    }
}

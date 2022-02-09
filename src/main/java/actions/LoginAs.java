package actions;

import lombok.AllArgsConstructor;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import tasks.LoginAsStandardUser;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class LoginAs implements Interaction {

    // Add user type information to perform the kind of conditional task

    public static LoginAs standardUser() {
        return instrumented(LoginAs.class);
    }
    private  Map<String, String> withCredentials(){
        Map<String, String> data = new HashMap<>();
        data.put("username", User.getStandardUser());
        data.put("password", User.getPassword());
        return data;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(LoginAsStandardUser.onTheSaucedemoPage(withCredentials()));
    }
}

package questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

import static ui.CheckoutPageUI.LBL_TAX;

@AllArgsConstructor
public class VerifyingTheTax implements Question<Boolean> {

    Map<String, String> data;


    public static VerifyingTheTax isTheValue(Map<String, String> correctValue) {
        return new VerifyingTheTax(correctValue);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return LBL_TAX.resolveFor(actor).getText().contains(data.get("Tax"));
    }
}

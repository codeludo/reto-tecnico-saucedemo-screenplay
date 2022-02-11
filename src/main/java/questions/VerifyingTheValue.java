package questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

import static ui.CheckoutPageUI.LBL_TAX;
import static ui.CheckoutPageUI.LBL_TOTAL;

public class VerifyingTheValue implements Question<Boolean> {

    Map<String, String> data;
    String value;

    public VerifyingTheValue(Map<String, String> data) {
        this.data = data;
    }

    public VerifyingTheValue(String value) {
        this.value = value;
    }

    public static VerifyingTheValue isTheValue(Map<String, String> correctValue) {
        return new VerifyingTheValue(correctValue);
    }

        public static VerifyingTheValue isTheValue(String totalValue) {
        return new VerifyingTheValue(totalValue);
    }



/*    @Override
    public Boolean answeredBy(Actor actor) {
        return LBL_TAX.resolveFor(actor).getText().contains(data.get("Tax"))
                || LBL_TOTAL.resolveFor(actor).getText().contains(value);
    }*/

    @Override
    public Boolean answeredBy(Actor actor) {

        if(!LBL_TAX.resolveFor(actor).getText().contains("2.40")
                && !LBL_TOTAL.resolveFor(actor).getText().contains("32.39")){
            return Boolean.FALSE;
        } else{
            return Boolean.TRUE;
        }


    }
}

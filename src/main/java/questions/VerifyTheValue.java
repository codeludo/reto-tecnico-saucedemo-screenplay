package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

import static ui.CheckoutPageUI.LBL_TAX;
import static ui.CheckoutPageUI.LBL_TOTAL;


public class VerifyTheValue implements Question<Boolean> {

    Map<String, String> data;
    String value;

    public VerifyTheValue(Map<String, String> data) {
        this.data = data;
    }

    public VerifyTheValue(String value) {
        this.value = value;
    }

    public static VerifyTheValue isTheValue(Map<String, String> correctValue) {
        return new VerifyTheValue(correctValue);
    }

        public static VerifyTheValue isTheValue(String totalValue) {
        return new VerifyTheValue(totalValue);
    }

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

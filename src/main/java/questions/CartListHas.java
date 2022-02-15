package questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static ui.CartPageUI.CART_ITEMS;

@AllArgsConstructor
public class CartListHas implements Question<Boolean> {

    int numberOfItems;

    public static CartListHas items(int number) {
        return new CartListHas(number);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        if(CART_ITEMS.resolveAllFor(actor).size()<6) return Boolean.FALSE;
        else return Boolean.TRUE;
    }
}


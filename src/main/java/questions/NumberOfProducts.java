package questions;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static ui.InventoryPageUI.INVENTORY_CONTAINER;
@AllArgsConstructor
public class NumberOfProducts implements Question<Boolean> {
    Integer number;
    public static NumberOfProducts is(Integer quantity) {
        return new NumberOfProducts(quantity);
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        return INVENTORY_CONTAINER.resolveAllFor(actor).size()==6;
    }
}

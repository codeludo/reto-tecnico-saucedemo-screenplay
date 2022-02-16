package questions;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static ui.InventoryPageUI.INVENTORY_LIST;
@AllArgsConstructor
public class ContainerHaveSix implements Question<Boolean> {
    Integer number;
    public static ContainerHaveSix items(Integer quantity) {
        return new ContainerHaveSix(quantity);
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        return INVENTORY_LIST.resolveAllFor(actor).size()==6;
    }
}

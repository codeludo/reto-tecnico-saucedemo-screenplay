package questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.Map;

import static ui.InventoryPageUI.ITEM;

@AllArgsConstructor
public class FirstItemName implements Question<Boolean> {
    Map.Entry<String, List<String>> selection;

    public static FirstItemName notMatch(Map.Entry<String, List<String>> entry) {
        return new FirstItemName(entry);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        if(ITEM.resolveFor(actor).containsText(selection.getValue().get(1))) return Boolean.FALSE;
        else return Boolean.TRUE;
    }
}
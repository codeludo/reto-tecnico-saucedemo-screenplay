package questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

import static ui.InventoryPageUI.ITEM_LBLNAME;
import static ui.InventoryPageUI.ITEM_LBLPRICE;

@AllArgsConstructor
public class OrderedItems implements Question<Boolean> {

    Map<String, String> item;

    public static OrderedItems throughSelection(Map<String, String> item) {
        return new OrderedItems(item);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean itemName = ITEM_LBLNAME.of(item.get("item")).resolveAllFor(actor).get(0).containsText(item.get("item"));
        Boolean itemPrice = ITEM_LBLPRICE.resolveFor(actor).getText().contains(item.get("price"));

        if(itemName && itemPrice) return Boolean.TRUE;
        else return Boolean.FALSE;
    }
}

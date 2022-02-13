package questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static ui.InventoryPageUI.SVG_PRODUCTS_COUNTER;

@AllArgsConstructor
public class ProductsResetInShoppingCartIcon implements Question<Boolean> {


    public static ProductsResetInShoppingCartIcon onInventoryPage() {
        return new ProductsResetInShoppingCartIcon();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return SVG_PRODUCTS_COUNTER.resolveFor(actor).isVisible();
    }
}

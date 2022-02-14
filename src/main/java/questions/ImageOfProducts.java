package questions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;

import static ui.InventoryPageUI.*;

@AllArgsConstructor
public class ImageOfProducts implements Question<Boolean> {


    public static ImageOfProducts areEquals() {
        return new ImageOfProducts();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        ArrayList<String> localImgArraySrc = new ArrayList<>();
        for (int i = 0; i < INVENTORY_CONTAINER.resolveAllFor(actor).size(); i++) {
            localImgArraySrc.add(ITEM_IMAGE.of(String.valueOf(i)).resolveFor(actor).getAttribute("src"));
        }
        
        for(String src: localImgArraySrc){
            if(!src.equals(localImgArraySrc.get(0))) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}

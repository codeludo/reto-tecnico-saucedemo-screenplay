package questions;


import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static net.serenitybdd.core.Serenity.getDriver;

@AllArgsConstructor
public class VerifyCurrentPage implements Question<Boolean> {

    Map<String, String> url;



    public static VerifyCurrentPage onTheInventoryPage(Map<String, String> withUrl) {
        return new VerifyCurrentPage(withUrl);
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        /*
         * Verifying current page
         * Also an alternative to study is:
         * Ensure.thatTheCurrentPage().currentUrl()
         * my problem is StringEnsure object to question
         */
        WebDriver driver = getDriver();
        String currentUrl = driver.getCurrentUrl();
        return currentUrl.contains(url.get("validation"));
    }


}

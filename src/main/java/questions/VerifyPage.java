package questions;


import com.google.common.base.Verify;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.KnowableAnswer;
import net.serenitybdd.screenplay.ensure.StringEnsure;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static net.serenitybdd.core.Serenity.getDriver;

@AllArgsConstructor
public class VerifyPage implements Question<Boolean> {

    Map<String, String> url;



    public static VerifyPage onTheInventoryPage(Map<String, String> withUrl) {
        return new VerifyPage(withUrl);
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

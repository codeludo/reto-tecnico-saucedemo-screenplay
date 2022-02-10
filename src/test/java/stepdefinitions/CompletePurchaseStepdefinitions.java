package stepdefinitions;

import actions.CheckoutPurchase;
import actions.LoginAs;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import org.hamcrest.Matchers;
import questions.TheSuccessfulMessageCheckout;
import tasks.ChooseProduct;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static ui.CheckoutPageUI.BTN_CONTINUE;
import static ui.CheckoutPageUI.BTN_FINISH;

public class CompletePurchaseStepdefinitions {

    //click on finish //*[@id="finish"]

    @When("finish the purchase")
    public void finish_the_purchase() {
        theActorInTheSpotlight().attemptsTo(Click.on(BTN_FINISH));

    }
    @Then("I should see the message {string}")
    public void i_should_see_the_message(String message) {
        theActorInTheSpotlight().should(seeThat(TheSuccessfulMessageCheckout.isTheMessage(message),
                Matchers.equalTo(Boolean.TRUE)));
    }
}

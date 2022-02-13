package stepdefinitions;

import actions.CheckoutPurchase;
import actions.ClickButton;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import org.hamcrest.Matchers;
import questions.TheSuccessfulMessageCheckout;
import questions.VerifyTheValue;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static ui.CheckoutPageUI.BTN_FINISH;

public class CheckoutStepdefinitions {


    //complete purchase

    @When("finish the purchase")
    public void finish_the_purchase() {
        theActorInTheSpotlight().attemptsTo(Click.on(BTN_FINISH));

    }
    @Then("I should see the message {string}")
    public void i_should_see_the_message(String message) {
        theActorInTheSpotlight().should(seeThat(TheSuccessfulMessageCheckout.isTheMessage(message),
                Matchers.equalTo(Boolean.TRUE)));
    }

    // tax

    @When("checkout my information")
    public void checkout_my_information(Map<String, String> withTax) {
        theActorInTheSpotlight().attemptsTo(ClickButton.toCheckout());
        theActorInTheSpotlight().attemptsTo(CheckoutPurchase.toVerifyPurchase(withTax));

    }
    @Then("validate that the tax is correct")
    public void validate_that_the_tax_is_correct(Map<String, String> correctValue) {
        theActorInTheSpotlight().should(seeThat(VerifyTheValue.isTheValue(correctValue),
                Matchers.equalTo(Boolean.TRUE)));
    }

    // total value

    @Then("I should see the value is {string}")
    public void i_should_see_the_value_is(String value) {
        theActorInTheSpotlight().should(seeThat(VerifyTheValue.isTheValue(value)));
    }
}

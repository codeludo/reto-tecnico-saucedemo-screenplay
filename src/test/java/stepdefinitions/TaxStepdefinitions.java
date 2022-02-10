package stepdefinitions;

import actions.CheckoutPurchase;
import actions.ClickButton;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import questions.VerifyingTheTax;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TaxStepdefinitions {

    // click checkout button //*[@id="checkout"] -

    // enter first name //*[@id="first-name"] -
    // enter last name //*[@id="last-name"]
    // enter zip code //*[@id="postal-code"]
    // click continue button //*[@id="continue"]

    // validate summary tax label //*[@id="checkout_summary_container"]/div/div[2]/div[6] contains 2.40

    @When("checkout my information")
    public void checkout_my_information(Map<String, String> withTax) {
        theActorInTheSpotlight().attemptsTo(ClickButton.toCheckout());
        theActorInTheSpotlight().attemptsTo(CheckoutPurchase.toVerifyPurchase(withTax));

    }
    @Then("validate that the tax is correct")
    public void validate_that_the_tax_is_correct(Map<String, String> correctValue) {
        theActorInTheSpotlight().should(seeThat(VerifyingTheTax.isTheValue(correctValue),
                Matchers.equalTo(Boolean.TRUE)));
    }

}

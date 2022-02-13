package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import questions.ErrorMessage;
import questions.NumberOfProducts;
import tasks.Login;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class loginStepdefinitions {

    @When("I login as {string}")
    public void i_login_as_(String typeUser) {
        theActorInTheSpotlight().attemptsTo(Login.as(typeUser));
    }

    // as standard_user, problem_user and performance_glitch_user
    @Then("I should see {int} products")
    public void i_should_see_products(Integer quantity) {
        theActorInTheSpotlight().should(seeThat(NumberOfProducts.is(quantity),
                Matchers.equalTo(Boolean.TRUE)));
    }

    @Then("I can see an error message")
    public void i_can_see_an_error_message() {
        theActorInTheSpotlight().should(seeThat(ErrorMessage.appears(),
                Matchers.equalTo(Boolean.TRUE)));
    }
}

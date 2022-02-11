package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import questions.OrderedItems;
import tasks.FilterItems;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class FilterStepdefinitions {


    @When("select the price filter")
    public void select_the_price_filter(Map<String, String> selection) {
        theActorInTheSpotlight().attemptsTo(FilterItems.throughSelection(selection));

    }
    @Then("first inventory list should contains filtered item")
    public void first_inventory_list_should_contains_filtered_item(Map<String, String> item) {
        theActorInTheSpotlight().should(seeThat(OrderedItems.throughSelection(item),
                Matchers.equalTo(Boolean.TRUE)));
    }


}

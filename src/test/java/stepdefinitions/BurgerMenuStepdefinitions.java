package stepdefinitions;

import actions.LoginAs;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import questions.VerifyPage;
import questions.ProductsResetInShoppingCartIcon;
import tasks.ChooseProduct;
import tasks.TestTheBurgerMenu;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BurgerMenuStepdefinitions {

    /*
    *
    * @burger-menu-3items
    *
     */

    @When("I select an option in main menu")
    public void i_select_an_option_in_main_menu(Map<String, String> data) {
        theActorInTheSpotlight().attemptsTo(LoginAs.standardUser());
        theActorInTheSpotlight().attemptsTo(TestTheBurgerMenu.selectingSomeMenu(data));
    }
    @Then("I should see that page change depends on selection")
    public void i_should_see_that_page_change_depends_on_selection(Map<String, String> withUrl) {
        theActorInTheSpotlight().should(seeThat(VerifyPage.onTheInventoryPage(withUrl)));
    }

    /*
    *
    * @burger-menu-resetStateItem
    *
     */

    @When("I want to reset the app state")
    public void i_want_to_reset_the_app_state(Map<String, String> data) {
        theActorInTheSpotlight().attemptsTo(LoginAs.standardUser());
        theActorInTheSpotlight().attemptsTo(ChooseProduct.onInventoryPage());
        theActorInTheSpotlight().attemptsTo(TestTheBurgerMenu.selectingSomeMenu(data));

    }
    @Then("I should see the items has been reset")
    public void i_should_see_the_items_has_been_reset() {
        theActorInTheSpotlight().should(seeThat(ProductsResetInShoppingCartIcon.onInventoryPage(),
                Matchers.equalTo(Boolean.FALSE)));
    }

}

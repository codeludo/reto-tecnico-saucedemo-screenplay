package stepdefinitions;

import actions.CheckoutPurchase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import org.hamcrest.Matchers;
import questions.*;
import tasks.ChooseAllProducts;
import tasks.GoToShoppingCart;
import tasks.Login;

import java.util.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static ui.CartPageUI.BTN_CHECKOUT;
import static ui.CartPageUI.BTN_CONTINUE_SHOPPING;
import static ui.InventoryPageUI.*;

public class loginStepdefinitions {

    //login
    @When("I login as {string}")
    public void i_login_as_(String typeUser) {
        theActorInTheSpotlight().attemptsTo(Login.as(typeUser));
    }


    // as standard_user, problem_user and performance_glitch_user
    @Then("I should see {int} products")
    public void i_should_see_products(Integer quantity) {
        theActorInTheSpotlight().should(seeThat(ContainerHaveSix.items(quantity),
                equalTo(Boolean.TRUE)));
    }

    /*
    ERROR TEST (proving that an error comes out)
     */
    //error message IN LOGIN FORM
    @Then("I can see an error message")
    public void i_can_see_an_error_message() {
        theActorInTheSpotlight().should(seeThat(ErrorMessage.appears(),
                equalTo(Boolean.TRUE)));
    }

    //problem user
    //images
    @Then("I can see in the inventory page all images are equals")
    public void i_can_see_in_the_inventory_page_all_images_are_equals() {
        theActorInTheSpotlight().should(seeThat(ImageOfProducts.areEquals(),
                equalTo(Boolean.TRUE)));
    }

    //adding items to shopping cart
    @Then("I only can add three items to shopping cart")
    public void i_only_can_add_three_items_to_shopping_cart() {
        theActorInTheSpotlight().attemptsTo(ChooseAllProducts.onInventoryPage());
        theActorInTheSpotlight().attemptsTo(GoToShoppingCart.onCartPage());
        theActorInTheSpotlight().should(seeThat(CartListHas.items(3),
                equalTo(Boolean.TRUE)));
    }

    //removing items from shopping cart
    @Then("I can not remove items from button in inventory")
    public void i_can_not_remove_items_from_button_in_inventory() {
        theActorInTheSpotlight().attemptsTo(Click.on(BTN_CONTINUE_SHOPPING));
        theActorInTheSpotlight().attemptsTo(ChooseAllProducts.onInventoryPage());
        theActorInTheSpotlight().attemptsTo(GoToShoppingCart.onCartPage());
        theActorInTheSpotlight().should(seeThat(CartListHas.items(3),
                equalTo(Boolean.TRUE)));
    }

    //filtering items
    @Then("I can not filter items")
    public void i_can_not_filter_items() {
        Map<String, List<String>> selection = new HashMap<>();
        selection.put("plh",Arrays.asList("Price (low to high)", "Sauce Labs Onesie", "$7.99"));
        selection.put("phl", Arrays.asList("Price (high to low)", "Sauce Labs Fleece Jacket", "$49.99"));
        selection.put("nza", Arrays.asList("Name (Z to A)","Test.allTheThings() T-Shirt (Red)", "$15.99"));
        Boolean firstItemName;
        theActorInTheSpotlight().attemptsTo(Click.on(BTN_CONTINUE_SHOPPING));

        for(Map.Entry<String, List<String>> entry: selection.entrySet()){
            theActorInTheSpotlight().attemptsTo(Click.on(SELECTION.of(entry.getValue().get(0))));
            theActorInTheSpotlight().should(seeThat(FirstItemName.notMatch(entry),
                    Matchers.equalTo(Boolean.TRUE)));
        }


    }

    //checking out
    @Then("checkout my information shows error message")
    public void checkout_my_information_shows_error_message() {
        theActorInTheSpotlight().attemptsTo(GoToShoppingCart.onCartPage());
        theActorInTheSpotlight().attemptsTo(Click.on(BTN_CHECKOUT));
        Map<String, String> data = new HashMap<>();
        data.put("First Name", "Camilo");
        data.put("Last Name", "A");
        data.put("Zip", "99999");
        theActorInTheSpotlight().attemptsTo(CheckoutPurchase.toVerifyPurchase(data));
        theActorInTheSpotlight().should(seeThat(ErrorMessage.appears()));
    }

    //glitch in login and back to home
    @Then("I can see a delay")
    public void i_can_see_a_delay(){
        theActorInTheSpotlight().should(seeThat(DelayOn.changePage()));
    }



}

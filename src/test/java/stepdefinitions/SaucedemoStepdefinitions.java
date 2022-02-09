package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import models.User;
import net.serenitybdd.core.annotations.events.BeforeExample;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import questions.VerifyPage;
import questions.VerifyProduct;
import tasks.ChooseProduct;
import tasks.GoToOtherPage;
import tasks.GoToShoppingCart;
import tasks.LoginAsStandardUser;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SaucedemoStepdefinitions {

/*
*   when I use @Managed and @Before with this setup
*   it only works one time each scenario but doesn't in each example
*   so throws this error
*   Session ID is null. Using WebDriver after calling quit()?*/


/*    @Managed
    private static WebDriver hisBrowser;

    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        hisBrowser = new ChromeDriver();
        hisBrowser.manage().window().maximize();
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("Camilo");
        theActorInTheSpotlight().can(BrowseTheWeb.with(hisBrowser));
    }*/

    /**
     *  shopping cart scenario
     *
     */
    @Given("that I am in the saucedemo page at {string}")
    public void that_i_am_in_the_saucedemo_page_at(String url) {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Camilo");
        theActorInTheSpotlight().wasAbleTo(Open.url(url));

    }


    @When("I login as standard user")
    public void i_login_as_standard_user(Map<String, String> data) {
        theActorInTheSpotlight().attemptsTo(LoginAsStandardUser.onTheSaucedemoPage(data));
    }
    @When("select any displayed result to go to the shopping cart")
    public void select_any_displayed_result_to_go_to_the_shopping_cart() {
        theActorInTheSpotlight().attemptsTo(ChooseProduct.onInventoryPage());
        theActorInTheSpotlight().attemptsTo(GoToShoppingCart.onCartPage());
    }
    @Then("should the shopping cart show the product is not null")
    public void should_the_shopping_cart_show_the_product_is_not_null() {
        theActorInTheSpotlight().should(seeThat(VerifyProduct.onCartPage(),
                Matchers.equalTo(Boolean.TRUE)));
    }

    /**
     *  main menu  scenario
     *
     */
    @When("I select an option in main menu")
    public void i_select_an_option_in_main_menu(Map<String, String> data) {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("username", User.getUsername());
        credentials.put("password", User.getPassword());
        theActorInTheSpotlight().attemptsTo(LoginAsStandardUser.onTheSaucedemoPage(credentials));
        theActorInTheSpotlight().attemptsTo(ChooseProduct.onInventoryPage());
        theActorInTheSpotlight().attemptsTo(GoToOtherPage.onMainMenu(data));
    }
    @Then("I should see depends on selection")
    public void i_should_see_depends_on_selection(Map<String, String> withUrl) {
        theActorInTheSpotlight().should(seeThat(VerifyPage.onTheInventoryPage(withUrl)));
    }




}

package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import models.MainMenuSelection;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import questions.VerifyProduct;
import tasks.ChooseProduct;
import tasks.GoToAbout;
import tasks.GoToShoppingCart;
import tasks.LoginAsStandardUser;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SaucedemoStepdefinitions {

    @Managed
    private static WebDriver hisBrowser;

    @Before
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        hisBrowser = new ChromeDriver();
        hisBrowser.manage().window().maximize();
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("Camilo");
        theActorInTheSpotlight().can(BrowseTheWeb.with(hisBrowser));
    }

    /**
     *  shopping cart scenario
     *
     */
    @Given("that I am in the saucedemo page at {string}")
    public void that_i_am_in_the_saucedemo_page_at(String url) {
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
    public void i_select_an_option_in_main_menu(MainMenuSelection data) {


        theActorInTheSpotlight().attemptsTo(GoToAbout.onMainMenu(data));
    }
    @Then("I should see depends on selection")
    public void i_should_see_depends_on_selection(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }




}

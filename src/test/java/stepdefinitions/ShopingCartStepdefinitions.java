package stepdefinitions;

import actions.LoginAs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import questions.VerifyProduct;
import tasks.ChooseProduct;
import tasks.GoToShoppingCart;
import tasks.LoginAsStandardUser;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ShopingCartStepdefinitions {

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
    public void i_login_as_standard_user() {
        theActorInTheSpotlight().attemptsTo(LoginAs.standardUser());
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
}

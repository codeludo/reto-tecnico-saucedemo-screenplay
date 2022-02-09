package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TaxStepdefinitions {

    // click checkout button //*[@id="checkout"]
    // enter first name //*[@id="first-name"]
    // enter last name //*[@id="last-name"]
    // enter zip code //*[@id="postal-code"]
    // click continue button //*[@id="continue"]
    // validate summary tax label //*[@id="checkout_summary_container"]/div/div[2]/div[6] contains 2.40

    @When("checkout my information")
    public void checkout_my_information(io.cucumber.datatable.DataTable dataTable) {

    }
    @Then("validate that the tax is exactly {int}%")
    public void validate_that_the_tax_is_exactly(Integer int1, io.cucumber.datatable.DataTable dataTable) {
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

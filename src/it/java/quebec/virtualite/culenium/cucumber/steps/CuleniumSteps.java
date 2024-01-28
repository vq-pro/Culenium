package quebec.virtualite.culenium.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import quebec.virtualite.culenium.page_object.GooglePageObject;

public class CuleniumSteps
{
    @Autowired
    GooglePageObject googlePage;

    @When("we go to Google.com")
    public void goToGoogle()
    {
        googlePage.go();
    }

    @Then("we are on Google")
    public void weAreOnGoogle()
    {
        googlePage.validateOnPage();
    }
}

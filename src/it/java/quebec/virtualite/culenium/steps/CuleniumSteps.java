package quebec.virtualite.culenium.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import quebec.virtualite.culenium.page_object.GooglePageObject;

@SpringBootTest
@CucumberContextConfiguration
public class CuleniumSteps
{
    @Autowired
    GooglePageObject googlePage;

    @Before
    public void beforeEachScenario()
    {
        // DELETE ALL BD
    }

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

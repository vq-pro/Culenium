package quebec.virtualite.culenium.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@CucumberContextConfiguration
public class CuleniumSteps
{
    public CuleniumSteps(
        @Value("${local.server.port}") int serverPort)
    {
    }

    @Before
    public void beforeEachScenario()
    {
        // DELETE ALL BD
    }

    @When("^we go to (.*)$")
    public void goTo(String url)
    {
    }

    @Then("we are on Google")
    public void weAreOnGoogle()
    {
    }
}

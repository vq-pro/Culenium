package quebec.virtualite.culenium.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import quebec.virtualite.culenium.page_object.WebBrowser;

@SpringBootTest
@CucumberContextConfiguration
public class CucumberConfiguration
{
    @Autowired
    WebBrowser web;

    @Before
    public void beforeEachScenario()
    {
        // DELETE ALL BD
    }

    @After
    public void afterEachScenario(Scenario scenario)
    {
        web.takeScreenshotIfFailed(scenario);
    }
}

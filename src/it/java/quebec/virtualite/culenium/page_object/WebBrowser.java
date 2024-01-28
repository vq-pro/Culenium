package quebec.virtualite.culenium.page_object;

import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.OutputType.BYTES;

@Component
public class WebBrowser
{
    private static final String IMAGE_JPG = "image/jpg";

    public WebDriver browser;

    @PostConstruct
    public void onInit()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setImplicitWaitTimeout(ofMillis(PageObject.POLLING_TIMEOUT_MS));

        browser = new ChromeDriver(options);
    }

    @PreDestroy
    public void onDestroy()
    {
        browser.close();
    }

    public void takeScreenshotIfFailed(Scenario scenario)
    {
        if (scenario.isFailed())
        {
            scenario.attach(captureScreenshot(), IMAGE_JPG, scenario.getName());
        }
    }

    private byte[] captureScreenshot()
    {
        return ((TakesScreenshot) browser).getScreenshotAs(BYTES);
    }
}

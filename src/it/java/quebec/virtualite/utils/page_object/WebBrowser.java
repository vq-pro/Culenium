package quebec.virtualite.utils.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static java.time.Duration.ofMillis;
import static quebec.virtualite.utils.page_object.PageObject.POLLING_TIMEOUT_MS;

@Component
public class WebBrowser
{
    public WebDriver browser;

    @PostConstruct
    public void onInit()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setImplicitWaitTimeout(ofMillis(POLLING_TIMEOUT_MS));

        browser = new ChromeDriver(options);
    }

    @PreDestroy
    public void onDestroy()
    {
        browser.close();
    }
}

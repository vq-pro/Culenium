package quebec.virtualite.utils.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class WebBrowser
{
    WebDriver browser;

    @PostConstruct
    public void onInit()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        browser = new ChromeDriver(options);
    }

    @PreDestroy
    public void onDestroy()
    {
        browser.close();
    }
}

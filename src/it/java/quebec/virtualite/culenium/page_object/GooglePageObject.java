package quebec.virtualite.culenium.page_object;

import org.springframework.stereotype.Component;
import quebec.virtualite.utils.page_object.PageObject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.By.xpath;

@Component
public class GooglePageObject extends PageObject
{
    public void go()
    {
        go("https://google.com");
    }

    public void validateOnPage()
    {
        assertThat(title()).isEqualTo("Google");
        assertTrue(exists(xpath("//textarea")));
    }
}

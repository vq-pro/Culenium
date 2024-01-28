package quebec.virtualite.culenium.page_object;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import quebec.virtualite.utils.page_object.PageObject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.xpath;

@Component
public class GooglePageObject extends PageObject
{
    private static final String EXPECTED_TITLE = "Google";
    private static final By SEARCH_FIELD = xpath("//textarea");

    public void go()
    {
        go("https://google.com");
    }

    public void validateOnPage()
    {
        assertThat(title()).isEqualTo(EXPECTED_TITLE);

        validateElementEnabled(SEARCH_FIELD);
    }
}

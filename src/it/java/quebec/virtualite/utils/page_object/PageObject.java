package quebec.virtualite.utils.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import quebec.virtualite.utils.RunnableNoTry;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static junit.framework.TestCase.fail;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static quebec.virtualite.utils.DevUtils.IMPLEMENT;

public abstract class PageObject
{
    @Autowired
    WebBrowser web;

    public String dumpSourceToStdout()
    {
        //        String html = web.page.asXml();
        //        System.out.println(html);
        //
        //        return html;

        return IMPLEMENT();
    }

    public void go(String url)
    {
        web.browser.get(url);
    }

    public String title()
    {
        return web.browser.getTitle();
    }

    protected void click(By locator)
    {
        click(element(locator));
    }

    protected WebElement element(By locator)
    {
        WebElement element = web.browser.findElement(locator);
        assertNotNull("element '" + locator.toString() + "' not found", element);

        return element;
    }

    protected String elementClass(By locator)
    {
        return element(locator).getAttribute("class");
    }

    protected String elementText(By locator)
    {
        return element(locator).getText().trim();
    }

    protected String elementValue(By locator)
    {
        return element(locator).getAttribute("value");
    }

    protected List<WebElement> elements(By locator)
    {
        List<WebElement> elements = web.browser.findElements(locator);
        assertThat(elements)
            .withFailMessage("elements '" + locator.toString() + "' not found")
            .isNotEmpty();

        return elements;
    }

    protected List<String> elementsAttribute(By locator, String attribute)
    {
        return exists(locator)
               ? elements(locator)
                   .stream()
                   .map(element -> element.getAttribute(attribute))
                   .map(String::trim)
                   .collect(toList())
               : emptyList();
    }

    protected List<String> elementsText(By locator)
    {
        return exists(locator)
               ? elements(locator)
                   .stream()
                   .map(WebElement::getText)
                   .map(String::trim)
                   .collect(toList())
               : emptyList();
    }

    protected List<String> elementsValue(By locator)
    {
        return elementsAttribute(locator, "value");
    }

    protected boolean exists(By locator)
    {
        return elements(locator) != null;
    }

    protected String idWithParam(By locator, long... ids)
    {
        StringBuilder builder = new StringBuilder()
            .append(locator)
            .append(ids[0]);

        for (int i = 1; i < ids.length; i++)
        {
            builder
                .append("-")
                .append(ids[i]);
        }

        return builder.toString();
    }

    protected void selectRadio(By locator, long idValue)
    {
        selectRadio(locator, String.valueOf(idValue));
    }

    protected void selectRadio(By locator, String value)
    {
        Optional<WebElement> groupMemberElement = elements(locator)
            .stream()
            .filter(element -> element.getAttribute("value").equals(value))
            .findFirst();

        assertThat(groupMemberElement.isPresent())
            .withFailMessage("'" + locator.toString() + "' not found!")
            .isTrue();

        click(groupMemberElement.get());
    }

    protected void setInput(By locator, String value)
    {
        element(locator).sendKeys(value);
    }

    protected void setInput(By locator, int value)
    {
        setInput(locator, String.valueOf(value));
    }

    protected void validateIsHidden(By locator)
    {
        if (exists(locator))
        {
            elementText(locator);
            fail("Element " + locator.toString() + " shouldn't exist [" + elementText(locator) + "]");
        }
    }

    private void click(WebElement element)
    {
        keepAuthentication(element::click);
    }

    private String elementAttribute(By locator, String attribute)
    {
        return element(locator).getAttribute(attribute);
    }

    private <T> List<T> emptyList()
    {
        return new ArrayList<>();
    }

    private void keepAuthentication(RunnableNoTry cmd)
    {
        Authentication authentication = SecurityContextHolder
            .getContext()
            .getAuthentication();

        try
        {
            cmd.run();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        SecurityContextHolder
            .getContext()
            .setAuthentication(authentication);
    }

    private void validateElementClass(By locator, String clasz)
    {
        assertThat(elementClass(locator))
            .withFailMessage("Bad class for '" + locator.toString() + "'")
            .contains(clasz);
    }

    private void validateElementDisabled(By locator)
    {
        assertThat(elementAttribute(locator, "disabled"))
            .withFailMessage("'" + locator.toString() + "' should be disabled")
            .isEqualTo("disabled");
    }

    private void validateElementEnabled(By locator)
    {
        assertThat(elementAttribute(locator, "disabled"))
            .withFailMessage("'" + locator + "' should not be disabled")
            .isNotEqualTo("disabled");
    }

    private void validateElementExists(By locator)
    {
        assertThat(exists(locator))
            .withFailMessage("Element " + locator + " doesn't exist")
            .isTrue();
    }

    private void validateElementText(By locator, String expectedText)
    {
        assertThat(elementText(locator))
            .withFailMessage("Bad text for '" + locator.toString() + "'")
            .isEqualTo(expectedText);
    }
}

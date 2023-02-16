package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver m_driver;
    protected WebDriverWait m_wait;
    private static final int DEFAULT_DURATION_TIME = 10;

    public BasePage(WebDriver driver){
        m_driver = driver;
        m_wait = new WebDriverWait(m_driver, Duration.ofSeconds(DEFAULT_DURATION_TIME));
        PageFactory.initElements(m_driver, this);
    }

    public void clickElement(WebElement element){
        m_wait.until(ExpectedConditions.elementToBeClickable(centerElement(element))).click();
    }
    public void sendKeys(WebElement element, String text){
        m_wait.until(ExpectedConditions.visibilityOf(centerElement(element))).sendKeys(text);
    }
    public WebElement centerElement(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) m_driver).executeScript(scrollElementIntoMiddle, element);
        return element;
    }
    public String getText(WebElement element){
        return m_wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public void selectElementsAndClick(List<WebElement> elements, String text){
        for (WebElement  select : m_wait.until(ExpectedConditions.visibilityOfAllElements(elements)))
            if (select.getText().equalsIgnoreCase(text))
                m_wait.until(ExpectedConditions.visibilityOf(centerElement(select))).click();
    }
    public void clickAllOfElements(List<WebElement> elements){
        for (WebElement element : elements)
            m_wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void clearField(WebElement element){
        m_wait.until(ExpectedConditions.visibilityOf(element)).clear();
    }
}

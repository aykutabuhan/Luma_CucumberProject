package runners;

import drivers.Driver;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/java/features/createAccountPage.feature"},
        plugin = {"summary", "pretty", "html:Reports/CucumberReport/Report.html"},
        glue = {"stepDefinitions"}
)

public class CreateAccountRunner extends AbstractTestNGCucumberTests {

    Driver m_driver = new Driver();

    @BeforeClass
    @Parameters({"browser", "host", "port"})
    public void initializationDriver(String browserName, String host, String port) throws MalformedURLException {

        if (browserName.equalsIgnoreCase("Chrome")){
            m_driver.setDriver(new RemoteWebDriver(new URL("http://" +host+ ":" +port+ "/wd/hub"), new ChromeOptions()));
        }
        else if (browserName.equalsIgnoreCase("Safari")) {
            m_driver.setDriver(new RemoteWebDriver(new URL("http://" +host+ ":" +port+ "/wd/hub"), new SafariOptions()));
        }
    }
    @AfterClass
    public void quit(){
        m_driver.getDriver().quit();
    }

}

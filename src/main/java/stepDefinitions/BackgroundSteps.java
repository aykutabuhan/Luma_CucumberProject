package stepDefinitions;

import drivers.Driver;
import io.cucumber.java.en.Given;

public class BackgroundSteps extends Driver {

    @Given("navigate to website {string}")
    public void navigateToWebsite(String url) {
        getDriver().get(url);
    }
}

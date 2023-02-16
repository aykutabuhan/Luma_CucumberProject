package stepDefinitions;

import drivers.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CreateAccountPage;

public class CreateAccountStep extends Driver {
    private final CreateAccountPage m_createAccountPage = new CreateAccountPage(getDriver());

    @And("fill first name {string}")
    public void fillFirstName(String firstName) {
        m_createAccountPage.fillFirstNameSpace(firstName);
    }
    @And("fill last name {string}")
    public void fillLastName(String lastName) {
        m_createAccountPage.fillLastNameSpace(lastName);
    }
    @And("click to sign up")
    public void clickToSignUp() {
        m_createAccountPage.clickSingUpBox();
    }
    @And("fill email {string}")
    public void fillEmail(String email) {
        m_createAccountPage.fillEmailSpace(email);
    }
    @And("fill password {string}")
    public void fillPassword(String password) {
        m_createAccountPage.fillPasswordSpace(password);
    }
    @And("fill confirm password {string}")
    public void fillConfirmPassword(String confirmPassword) {
        m_createAccountPage.fillConfirmPasswordSpace(confirmPassword);
    }
    @When("click create new account")
    public void clickCreateNewAccount() {
        m_createAccountPage.clickCreateAccountButton();
    }
    @Then("verify create new account {string}")
    public void verifyCreateNewAccount(String verificationMessage) {
        Assert.assertEquals(m_createAccountPage.getVerificationMessage(), verificationMessage);
    }
}

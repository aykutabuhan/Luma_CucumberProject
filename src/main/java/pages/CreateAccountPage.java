package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage{
    @FindBy(css = "input[id='firstname']")
    private WebElement firstNameSpace;
    @FindBy(css = "input[id='lastname']")
    private WebElement lastNameSpace;
    @FindBy(css = "input[id='is_subscribed']")
    private WebElement signUpForNewsletterRadioButton;
    @FindBy(css = "input[id='email_address']")
    private WebElement emailSpace;
    @FindBy(css = "input[id='password']")
    private WebElement passwordSpace;
    @FindBy(css = "input[id='password-confirmation']")
    private WebElement confirmPasswordSpace;
    @FindBy(css = "button[class='action submit primary']")
    private WebElement createAnAccountButton;
    @FindBy(css = "div[class=\"message-success success message\"] div")
    private WebElement verificationMessage;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }
    public void fillFirstNameSpace(String name){
        sendKeys(firstNameSpace, name);
    }
    public void fillLastNameSpace(String lastName){
        sendKeys(lastNameSpace, lastName);
    }
    public void clickSingUpBox(){
        clickElement(signUpForNewsletterRadioButton);
    }
    public void fillEmailSpace(String email){
        sendKeys(emailSpace, email);
    }
    public void fillPasswordSpace(String password){
        sendKeys(passwordSpace, password);
    }
    public void fillConfirmPasswordSpace(String confirmPassword){
        sendKeys(confirmPasswordSpace, confirmPassword);
    }
    public void clickCreateAccountButton(){
        clickElement(createAnAccountButton);
    }
    public String getVerificationMessage(){
        return getText(verificationMessage);
    }
}

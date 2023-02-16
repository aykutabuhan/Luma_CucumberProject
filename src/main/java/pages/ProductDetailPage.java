package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductDetailPage extends BasePage{

    @FindBy(css = "div[aria-labelledby*='option-label-size'] div")
    private List<WebElement> sizeOfBodies;
    @FindBy(css = "div[aria-labelledby*='option-label-color'] div")
    private List<WebElement> optionOfColors;
    @FindBy(css = "div[class='control'] input[id='qty']")
    private WebElement quantityField;
    @FindBy(css = "button[id='product-addtocart-button']")
    private WebElement addToCartButton;
    @FindBy(css = "div[data-ui-id='message-success'] div")
    private WebElement addedCartMessageText;


    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    public void selectSizeofHoodie(String size){
       selectElementsAndClick(sizeOfBodies, size);
    }
    public void selectColorOfHoodie(){
        clickAllOfElements(optionOfColors);
    }
    public void entryNewQuantity(String quantity){
        clearField(quantityField);
        sendKeys(quantityField, quantity);
    }
    public void addToCartButton(){
        clickElement(addToCartButton);
    }
    public String getAddedCartMessage(){
        return getText(addedCartMessageText);
    }
}

package stepDefinitions;

import drivers.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ProductDetailPage;

public class ProductDetailPageStep extends Driver {

    private final ProductDetailPage m_productDetailPage = new ProductDetailPage(getDriver());
    private static final String MESSAGE = "You added Marco Lightweight Active Hoodie to your shopping cart.";

    @And("select size {string}")
    public void selectSize(String size) {
        m_productDetailPage.selectSizeofHoodie(size);
    }

    @And("select random any color")
    public void selectRandomAnyColor() {
        m_productDetailPage.selectColorOfHoodie();
    }

    @And("select quantities of product {string}")
    public void selectQuantitiesOfProduct(String qty) {
        m_productDetailPage.entryNewQuantity(qty);
    }

    @When("click add to cart")
    public void clickAddToCart() {
        m_productDetailPage.addToCartButton();
    }

    @Then("verify add to cart with message")
    public void verifyAddToCartWithMessage() {
        Assert.assertEquals(m_productDetailPage.getAddedCartMessage(), MESSAGE);
    }
}

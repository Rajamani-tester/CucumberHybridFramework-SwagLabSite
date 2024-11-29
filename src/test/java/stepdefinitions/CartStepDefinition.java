package stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductPage;
import utils.CommonUtils;

public class CartStepDefinition {

	WebDriver driver;
	CartPage cartpage;
	ProductPage productpage;
	CheckoutPage checkoutpage;
	
	@And("User go to the cart page")
	public void user_go_to_the_cart_page() {
		driver = TestBase.getDriver();
		cartpage = new CartPage(driver);
		cartpage.clickOnCartIcon();
	}
	
	@Then("the cart should contain {int} item")
	public void the_cart_should_contain_item(Integer noOfItem) {
	    Assert.assertEquals(noOfItem, cartpage.getNoOfItemInCartPage());
	}
	
	@And("the item in the cart should be {string}")
	public void the_item_in_the_cart_should_be(String productName) {
	    Assert.assertEquals(cartpage.getProductName(), productName);
	}
	
	@And("the total price should be {double}")
	public void the_total_price_should_be(Double totalPrice) {
	    List<String>productPrices = cartpage.getListOfProductPrices();
	    double totalSumOfProductPrice = CommonUtils.sumList(CommonUtils.convertStringListToDoubleList(productPrices));
	    Assert.assertEquals(totalPrice, totalSumOfProductPrice);
	}
	
	@And("the items in the cart should be {string} and {string}")
	public void the_items_in_the_cart_should_be_and(String productOne, String productTwo) {
	    List<String> products = CommonUtils.convertToList(productOne, productTwo);
	    Assert.assertEquals(products, cartpage.getListOfProductNames());
	}
	
	@Then("User removes {string} from the cart")
	public void user_removes_from_the_cart(String string) {
		driver = TestBase.getDriver();
		cartpage = new CartPage(driver);
		cartpage.removeProductFromTheCart(string);
	}
	
	@When("User clicks Checkout")
	public void user_clicks_checkout() {
	    cartpage.clickOnCheckout();
	}

	@Then("the user should be redirected to the checkout page")
	public void the_user_should_be_redirected_to_the_checkout_page() {
	    checkoutpage = new CheckoutPage(driver);
	    Assert.assertEquals("Checkout: Your Information", checkoutpage.getCheckoutHeading());
	}
	
	@When("User clicks Continue Shopping")
	public void user_clicks_continue_shopping() {
		driver = TestBase.getDriver();
		cartpage = new CartPage(driver);
		cartpage.clickOnContinueShoppingButton();
	}

	@Then("the user should be redirected to the inventory page")
	public void the_user_should_be_redirected_to_the_inventory_page() {
		driver = TestBase.getDriver();
		productpage = new ProductPage(driver);
		Assert.assertEquals("Products", productpage.getProductPageHeading());
	}
}

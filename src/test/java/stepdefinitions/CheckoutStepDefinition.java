package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;

public class CheckoutStepDefinition {
	
	CheckoutPage checkoutpage;
	WebDriver driver;
	CheckoutOverviewPage checkoutoverviewpage;
	CheckoutCompletePage checkoutcompletepage;
	
	@When("User enters {string} in the First Name field")
	public void user_enters_in_the_first_name_field(String string) {
		driver = TestBase.getDriver();
	    checkoutpage = new CheckoutPage(driver);
		checkoutpage.enterFirstName(string);
	}

	@When("User enters {string} in the Last Name field")
	public void user_enters_in_the_last_name_field(String string) {
	    checkoutpage.enterLastName(string);
	}

	@When("User enters {string} in the Zip\\/Postal Code field")
	public void user_enters_in_the_zip_postal_code_field(String string) {
	    checkoutpage.enterPostalCode(string);
	}

	@When("User clicks Continue")
	public void user_clicks_continue() {
	    checkoutpage.clickOnContinueButton();
	}

	@Then("the user should be redirected to the confirmation page")
	public void the_user_should_be_redirected_to_the_confirmation_page() {
		driver = TestBase.getDriver();
		checkoutoverviewpage = new CheckoutOverviewPage(driver);
	    Assert.assertEquals("Checkout: Overview", checkoutoverviewpage.getCheckoutOverviewHeading());
	}
	
	@Then("the order details should be correct product name {string}, product count {int}, product price {double}")
	public void the_order_details_should_be_correct_product_name_product_count_product_price(String product, Integer noOfItem, Double productPrice) {
		Assert.assertEquals(product,checkoutoverviewpage.getProductName());
		Assert.assertEquals(noOfItem, checkoutoverviewpage.getNoOfProduct());
		Assert.assertEquals(productPrice, checkoutoverviewpage.getProductPrice());
		
	}

	@And("User clicks Finish")
	public void user_clicks_Finish() {
	    checkoutoverviewpage.clickOnFinishButton();
	}

	@And("User should recieve order sucessfully placed Message")
	public void user_should_recieve_order_sucessfully_placed_message() {
		driver = TestBase.getDriver();
	    checkoutcompletepage = new CheckoutCompletePage(driver);
	    Assert.assertEquals("THANK YOU FOR YOUR ORDER", checkoutcompletepage.getOrderSucessfullyPlacedMsg());
	}
}

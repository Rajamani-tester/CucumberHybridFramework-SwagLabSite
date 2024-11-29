package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductPage;
import utils.CommonUtils;

public class InventoryStepDefinition{

	WebDriver driver;
	ProductPage productpage;
	LoginPage loginpage;
	
	@Given("User is on the inventory page")
	public void user_is_on_the_inventory_page() {
		driver = TestBase.getDriver();
	    loginpage = new LoginPage(driver);
	    loginpage.login("standard_user", "secret_sauce");
	}

	@Then("The page displays the following items:")
	public void the_page_displays_the_following_items(io.cucumber.datatable.DataTable items) {
		for (int i = 0; i < items.height(); i++) {
			String productName = items.cell(i, 0);
			String productPrice = items.cell(i, 1).replace("$", "");
			String product = CommonUtils.findProductByName(driver, productName).getText();
			Assert.assertEquals(productName, product);
			String price = CommonUtils.findProductByName(driver, productPrice).getText();
			price = price.replace("$", "");
			Assert.assertEquals(productPrice, price);
		}
	}

	@When("User adds {string} to the cart")
	public void user_adds_to_the_cart(String productName) {
		driver = TestBase.getDriver();
		productpage = new ProductPage(driver);
		productpage.addToCartByProductName(driver, productName);
	}

	@Then("The cart count is updated to {string}")
	public void the_cart_count_is_updated_to(String productCount) {
		Assert.assertEquals(productCount,
				productpage.getCartItemCount());
	}
	
	@When("User selects the {string} option from the sorting dropdown")
	public void user_selects_the_option_from_the_sorting_dropdown(String dropdownOption) {
		productpage = new ProductPage(driver);
		productpage.selectSortOptionInDropdown(dropdownOption);
	}

	@Then("The items are displayed in ascending order of price")
	public void the_items_are_displayed_in_ascending_order_of_price() {
		Assert.assertTrue((productpage.getAllDisplayedProductPrices()).equals(CommonUtils.sortNumbersAscending(productpage.getAllDisplayedProductPrices())));
	}
	
	@Then("The items are displayed in descending order of price")
	public void the_items_are_displayed_in_descending_order_of_price() {
       Assert.assertTrue((productpage.getAllDisplayedProductPrices()).equals(CommonUtils.sortNumbersDescending(productpage.getAllDisplayedProductPrices())));
	}
	
	@Then("The items are displayed in alphabetical order by product name in ascending order")
	public void the_items_are_displayed_in_alphabetical_order_by_product_name_in_asceding_order() {
       Assert.assertTrue((productpage.getAllDisplayedProductNames()).equals(CommonUtils.sortList(productpage.getAllDisplayedProductNames())));
	}
	
	@Then("The items are displayed in alphabetical order by product name in descending order")
	public void the_items_are_displayed_in_alphabetical_order_by_product_name_in_descending_order() {
       Assert.assertTrue((productpage.getAllDisplayedProductNames()).equals(CommonUtils.sortListDescending(productpage.getAllDisplayedProductNames())));
	}
	
	@When("User clicks on Open Menu")
	public void user_clicks_on_open_menu() {
		productpage = new ProductPage(driver);
		productpage.openMenuTab();
	}
	
	@Then("The menu is displayed")
	public void the_menu_is_dipslayed() {
		Assert.assertTrue(productpage.closeButtonIsEnabled());
	}
	
	@When("User clicks on Close Menu")
	public void user_clicks_on_close_menu() throws InterruptedException {
		productpage.closeMenuTab();
	}
	
	@Then("The menu is hidden")
	public void the_menu_is_hidden() {
		Assert.assertTrue(productpage.closeButtonIsEnabled());
	}
	
	@Then("User clicks on Logout")
	public void user_clicks_on_logout() {
		productpage.clickOnLogout();
	}
	
	@Then("User is redirected to the login page")
	public void user_is_redirected_to_login_page() {
		Assert.assertTrue(loginpage.loginLogoIsDisplayed());
	}

}
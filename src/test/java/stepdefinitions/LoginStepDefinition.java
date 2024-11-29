package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductPage;

public class LoginStepDefinition{

	WebDriver driver;
	LoginPage loginpage;
	ProductPage productpage;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		driver = TestBase.getDriver();
		Assert.assertTrue(driver.findElement(By.className("bot_column")).isDisplayed());
	}

	@When("User enters {string} and {string}")
	public void user_enters_username_and_password(String username, String password) {
	    loginpage =  new LoginPage(driver);
	    loginpage.enterUsername(username);
	    loginpage.enterPassword(password);
	    
	}

	@And("Clicks on Login Button")
	public void clicks_on_login_button() {
	    
		loginpage.clickOnLoginButton();
	}

	@Then("User is navigated to Home Page")
	public void user_is_navigated_to_home_page() {
		productpage = new ProductPage(driver);
	    Assert.assertEquals("Products", productpage.getProductPageHeading()); 
	    
	}
	
	@Then("An error message is displayed {string}")
	public void an_error_message_is_displayed(String errorMsg) {
	    Assert.assertTrue(loginpage.getLoginWarningMessage().contains(errorMsg)); 
	    
	}
	
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (className = "subheader")
	private WebElement checkoutHeading;
	
	@FindBy (id = "first-name")
	private WebElement firstNameField;
	
	@FindBy (id = "last-name")
	private WebElement lastNameField;
	
	@FindBy (id = "postal-code")
	private WebElement postalCodeField;
	
	@FindBy (xpath = "//input[contains(@class,'cart_button')]")
	private WebElement continueButton;
	
	public String getCheckoutHeading() {
		return checkoutHeading.getText();
	}
	
	public void enterFirstName(String firstname) {
		firstNameField.sendKeys(firstname);
	}
	
	public void enterLastName(String lastname) {
		lastNameField.sendKeys(lastname);
	}
	
	public void enterPostalCode(String postalcode) {
		postalCodeField.sendKeys(postalcode);
	}
	
	public void clickOnContinueButton() {
		continueButton.click();
	}

}

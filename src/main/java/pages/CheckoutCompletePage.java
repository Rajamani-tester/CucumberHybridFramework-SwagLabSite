package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {

WebDriver driver;
	
	public CheckoutCompletePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (className = "complete-header")
	private WebElement OrderSucessfullyPlacedMsg;
	
	public String getOrderSucessfullyPlacedMsg() {
		return OrderSucessfullyPlacedMsg.getText();
	}
}
